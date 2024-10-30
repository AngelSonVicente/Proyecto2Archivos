/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import DatosBD.ConexionBD;
import Model.Archivo;
import Model.Carpeta;
import Model.JsonUtil;
import Model.User;
import Model.Usuario;
import Model.Util;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author MSI
 */
public class UsuarioBD {

    ConexionMongo conexionMongo;
    JsonUtil jsonUtil = new JsonUtil();
   
    
    public UsuarioBD() {

        conexionMongo = new ConexionMongo();

    }

   
    
    public Usuario getUsuarioByUser(String usuario) throws IOException {

        Document filtro = new Document("usuario", usuario);

        MongoIterable<Document> documents = conexionMongo.getConnection().getCollection("usuarios").find(filtro);

        if (documents.iterator().hasNext()) {

            System.out.println("\n\n\nUSUARIO ENCONTRADO_______________________________________________________");

            for (Document doc : documents) {

                Usuario userBD = (Usuario) jsonUtil.JsonStringAObjeto(doc.toJson(), Usuario.class);
                System.out.println(doc.toJson() + "\n" + userBD);

                userBD.setPassword(" ");

                return userBD;

            }

        }

        return null;

    }

    public User getUsuarioCompletoByUser(String usuario) throws IOException {

        Document filtro = new Document("usuario", usuario);

        Document doc = conexionMongo.getConnection().getCollection("usuarios").find(filtro).first();

        return doc != null ? mapearDocumentoAUsuario(doc) : null;

    }

    private User mapearDocumentoAUsuario(Document doc) {

        return new User(doc.getObjectId("_id").toString(), doc.getString("usuario"), doc.getString("nombre"), doc.getString("correo"), null, doc.getString("tipo"), mapearDocumentoACarpeta(doc.get("carpetaRaiz", Document.class)));

    }

    private Carpeta mapearDocumentoACarpeta(Document doc) {
        Carpeta carpeta = new Carpeta();
        carpeta.setId(doc.getObjectId("_id").toString());
        carpeta.setNombre(doc.getString("nombre"));

        List<Document> archivosDoc = (List<Document>) doc.get("archivos");
        List<Archivo> archivos = archivosDoc.stream().map(this::mapearDocumentoAArchivo).toList();
        carpeta.setArchivos(archivos);

        List<Document> subcarpetasDoc = (List<Document>) doc.get("subcarpetas");
        List<Carpeta> subcarpetas = subcarpetasDoc.stream().map(this::mapearDocumentoACarpeta).toList();
        carpeta.setSubcarpetas(subcarpetas);

        return carpeta;
    }

    private Archivo mapearDocumentoAArchivo(Document doc) {
        Archivo archivo = new Archivo();
        archivo.setId(doc.getObjectId("_id").toString());
        archivo.setNombre(doc.getString("nombre"));
        archivo.setTipo(doc.getString("tipo"));

        archivo.setTamaño(doc.getInteger("tamaño"));
        return archivo;
    }

    // Método para agregar una subcarpeta a una carpeta existente por su _id
    public boolean agregarSubcarpeta(String usuarioId, String carpetaId, String nombreSubcarpeta) {
        // Crear la subcarpeta sin especificar un _id (MongoDB asignará uno automáticamente)
        Document subcarpeta = new Document()
                .append("nombre", nombreSubcarpeta)
                .append("archivos", new ArrayList<>())
                .append("subcarpetas", new ArrayList<>());

        // Filtro para localizar al usuario y la carpeta específica en la estructura anidada
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.subcarpetas._id", new ObjectId(carpetaId))
        );

        // Actualización para añadir la subcarpeta en la lista "subcarpetas" de la carpeta especificada
        Bson actualizacion = Updates.push("carpetaRaiz.subcarpetas.$.subcarpetas", subcarpeta);

        // Ejecutar la actualización
        return conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion).getModifiedCount() > 0;
    }

    // Método para agregar un archivo a una carpeta específica por su _id
    public boolean agregarArchivo(String usuarioId, String carpetaId, String nombreArchivo, String tipo, byte[] contenido, int tamaño) {
        // Crear el archivo como un documento sin especificar un _id
        Document archivo = new Document()
                .append("nombre", nombreArchivo)
                .append("tipo", tipo)
                .append("contenido", contenido) // Puede ser BinData si es binario
                .append("tamaño", tamaño);

        // Filtro para ubicar al usuario y la carpeta específica dentro de la estructura
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.subcarpetas._id", new ObjectId(carpetaId))
        );

        // Actualización para añadir el archivo en la lista "archivos" de la carpeta especificada
        Bson actualizacion = Updates.push("carpetaRaiz.subcarpetas.$.archivos", archivo);

        // Ejecutar la actualización
        return conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion).getModifiedCount() > 0;
    }

    // Método para obtener una subcarpeta específica por su _id
    public Carpeta getSubcarpeta(String usuarioId, String carpetaId) {
        // Filtro para buscar la subcarpeta dentro de la estructura anidada del usuario
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.elemMatch("carpetaRaiz.subcarpetas", Filters.eq("_id", new ObjectId(carpetaId)))
        );

        // Campos proyectados para devolver solo la subcarpeta encontrada
        Bson proyeccion = new Document("carpetaRaiz.subcarpetas.$", 1);

        // Realizar la consulta
        Document usuario = conexionMongo.getConnection().getCollection("usuarios").find(filtro)
                .projection(proyeccion)
                .first();

        if (usuario != null) {
            // Extraer la subcarpeta de la estructura anidada
            Document carpetaRaiz = (Document) usuario.get("carpetaRaiz");
            if (carpetaRaiz != null) {
                List<Document> subcarpetas = (List<Document>) carpetaRaiz.get("subcarpetas");
                if (subcarpetas != null && !subcarpetas.isEmpty()) {
                    return mapearDocumentoACarpeta(subcarpetas.get(0));  // Devuelve la subcarpeta encontrada
                }
            }
        }
        return null; // Retorna null si no se encuentra la subcarpeta
    }
    
    
    
     public Usuario crearUsuario(Usuario usuario) {
        // Crear el documento del usuario
        Document usuarioCrear = new Document("nombre", usuario.getNombre())
                .append("usuario", usuario.getUsuario())
                .append("password", Util.Encriptar(usuario.getPassword()))
                .append("email", usuario.getCorreo())
                .append("tipo", "usuario")
                .append("carpetaRaiz", new Document()
                        .append("nombre", "nube"+usuario.getUsuario())
                   
                        .append("archivos", new ArrayList<>())
                        .append("subcarpetas", new ArrayList<>())
                );

        // Insertar el usuario en la colección
        conexionMongo.getConnection().getCollection("usuarios").insertOne(usuarioCrear);

        System.out.println("Usuario creado exitosamente: " + usuarioCrear.toJson());
        
        return usuario;
    }
    
    
    

//    private Connection conexion;
//
//    public UsuarioBD(Connection conexion) {
//        this.conexion = conexion;
//    }
//
//    public UsuarioBD() {
//        conexion = ConexionBD.getInstancia().getConexion();
//
//    }
//
//    private static final String SelectUsuario = "SELECT * FROM usuarios WHERE usuario = ?";
//    private static final String SelectUsuarioID = "SELECT * FROM usuarios WHERE codigo = ?";
//    private static final String SelectUsuarioCorreo = "SELECT * FROM usuarios WHERE correo = ?";
//    private static final String Insert = "INSERT INTO usuarios (codigo, nombre, usuario, password, direccion, correo, cui, birth, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    private static final String cambiarPassword = "UPDATE usuarios SET password = ? WHERE codigo = ?";
//    private static final String actualizarUsuario = "UPDATE usuarios SET nombre = ?, direccion = ?, correo = ?, cui = ?, birth = ? WHERE codigo = ?";
//    private static final String ExisteCorreYUsuario = "SELECT * FROM usuarios WHERE usuario = ? OR correo = ? ";
//
//    private static final String Dashboard = "SELECT COUNT(CASE WHEN tipo = 'Empleador' THEN 1 END) AS total_empleadores, COUNT(CASE WHEN tipo = 'Usuario' THEN 1 END) AS total_usuarios FROM usuarios;";
//    Util util = new Util();
//
//    public Usuario crearUsuario(Usuario usuario) {
//        System.out.println("esta creando el usuario");
//        try {
//            PreparedStatement insert = conexion.prepareStatement(Insert, PreparedStatement.RETURN_GENERATED_KEYS);
//            insert.setInt(1, usuario.getCodigo());
//            insert.setString(2, usuario.getNombre());
//            insert.setString(3, usuario.getUsuario());
//            insert.setString(4, util.Encriptar(usuario.getPassword()));
//            insert.setString(5, usuario.getDireccion());
//            insert.setString(6, usuario.getCorreo());
//            insert.setString(7, usuario.getCui());
//            insert.setString(8, usuario.getBirth());
//            insert.setString(9, usuario.getTipo());
//
//            System.out.println(insert.toString());
//            int affectedRows = insert.executeUpdate();
//
//            if (affectedRows == 0) {
//                throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
//            }
//
//            try (ResultSet generatedKeys = insert.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    int generatedID = generatedKeys.getInt(1);
//                    System.out.println("categoria Creada");
//                    usuario.setCodigo(generatedID);
//                    return usuario;
//                } else {
//                    throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println("----------------------------------");
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//
//    
//
//    public  Usuario getUsuarioByUser(String usuario) {
//        // validateCarnet not null
//        try {
//            PreparedStatement select = conexion.prepareStatement(SelectUsuario);
//            select.setString(1, usuario);
//            ResultSet resultset = select.executeQuery();
//
//            if (resultset.next()) {
//                return new Usuario(resultset.getInt("codigo"),
//                        resultset.getString("nombre"), resultset.getString("usuario"),
//                        resultset.getString("direccion"), resultset.getString("correo"), "",
//                        resultset.getString("cui"), resultset.getString("birth"), resultset.getString("tipo"),
//                        resultset.getBytes("cv"));
//            }
//
//            return null;
//        } catch (SQLException ex) {
//            // TODO pendiente manejo
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public  Usuario getUsuarioCodigo(String codigo) {
//        // validateCarnet not null
//        try {
//            PreparedStatement select = conexion.prepareStatement(SelectUsuarioID);
//            select.setString(1, codigo);
//            ResultSet resultset = select.executeQuery();
//            System.out.println("----------------------------------------------------");
//            System.out.println(select.toString());
//
//            if (resultset.next()) {
//                return new Usuario(resultset.getInt("codigo"),
//                        resultset.getString("nombre"), resultset.getString("usuario"),
//                        resultset.getString("direccion"), resultset.getString("correo"), "",
//                        resultset.getString("cui"), resultset.getString("birth"), resultset.getString("tipo"),
//                        resultset.getBytes("cv"));
//            }
//
//            return null;
//        } catch (SQLException ex) {
//            // TODO pendiente manejo
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public Usuario getUsuarioCorreo(String correo) {
//        // validateCarnet not null
//        try {
//            PreparedStatement select = conexion.prepareStatement(SelectUsuarioCorreo);
//            select.setString(1, correo);
//            ResultSet resultset = select.executeQuery();
//            System.out.println("----------------------------------------------------");
//            System.out.println(select.toString());
//
//            if (resultset.next()) {
//                return new Usuario(resultset.getInt("codigo"),
//                        resultset.getString("nombre"), resultset.getString("usuario"),
//                        resultset.getString("direccion"), resultset.getString("correo"), "",
//                        resultset.getString("cui"), resultset.getString("birth"), resultset.getString("tipo"),
//                        resultset.getBytes("cv"));
//            }
//
//            return null;
//        } catch (SQLException ex) {
//            // TODO pendiente manejo
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public boolean cambiarPassword(String codigoUsuario, String password) {
//
//        System.out.println("Actualizando la password");
//        try {
//            PreparedStatement update = conexion.prepareStatement(cambiarPassword);
//            update.setString(1, util.Encriptar(password));
//            update.setString(2, codigoUsuario);
//            System.out.println("QueryFinalizacion : " + update.toString());
//            int affectedRows = update.executeUpdate();
//
//            if (affectedRows == 1) {
//                return true;
//            } else {
//                System.out.println("La actualización no tuvo éxito.");
//                return false;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//        }
//
//        return false;
//    }
//
//    public boolean ActualizarUsuario(Usuario usuario) {
//
//        System.out.println("Actualizando la password");
//        try {
//            PreparedStatement update = conexion.prepareStatement(actualizarUsuario);
//            update.setString(1, usuario.getNombre());
//            update.setString(2, usuario.getDireccion());
//            update.setString(3, usuario.getCorreo());
//            update.setString(4, usuario.getCui());
//            update.setString(5, usuario.getBirth());
//            update.setInt(6, usuario.getCodigo());
//            System.out.println("QueryActualizacion: " + update.toString());
//            int affectedRows = update.executeUpdate();
//
//            if (affectedRows == 1) {
//                return true;
//            } else {
//                System.out.println("La actualización no tuvo éxito.");
//                return false;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println(ex);
//        }
//
//        return false;
//    }
}
