/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.Archivo;
import Model.CrearArchivo;
import Model.JsonUtil;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author angel
 */
public class ArchivoBD {

    ConexionMongo conexionMongo;
    JsonUtil jsonUtil = new JsonUtil();

    public ArchivoBD() {

        conexionMongo = new ConexionMongo();
    }

    //meter archivo dentro de carpeta raiz
    // Método para agregar un archivo directamente en la carpetaRaiz
    public Archivo agregarArchivoEnCarpetaRaiz(String usuarioId, String nombreArchivo, String tipo, String path) {
        // Crear el archivo como un documento sin especificar un _id

        ObjectId id = new ObjectId();
        Document archivo = new Document()
                .append("_id", id) // MongoDB asignará un _id automáticamente
                .append("nombre", nombreArchivo)
                .append("path", path + "/" + nombreArchivo)
                .append("tipo", tipo)
                .append("contenido", " ");

        // Filtro para ubicar al usuario por su _id
        Bson filtro = Filters.eq("_id", new ObjectId(usuarioId));

        // Actualización para añadir el archivo en la lista "archivos" de la carpetaRaiz
        Bson actualizacion = Updates.push("carpetaRaiz.archivos", archivo);

        // Ejecutar la actualización
        if (conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion).getModifiedCount() > 0) {

            return new Archivo(id.toString(), null, nombreArchivo, "", tipo, "", 0);

        }

        return null;
    }

    // Meter archivo dentro de alguna carpeta
    public Archivo agregarArchivo(String usuarioId, String carpetaId, String nombreArchivo, String tipo, String path) {
        // Crear el archivo como un documento sin especificar un _id

        ObjectId ID = new ObjectId();
        Document archivo = new Document()
                .append("_id", ID) // MongoDB asignará un _id automáticamente
                .append("nombre", nombreArchivo)
                .append("path", path + "/" + nombreArchivo)
                .append("tipo", tipo)
                .append("contenido", " ");
        // Filtro para ubicar al usuario y la carpeta específica dentro de la estructura
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.subcarpetas._id", new ObjectId(carpetaId))
        );

        // Actualización para añadir el archivo en la lista "archivos" de la carpeta especificada
        Bson actualizacion = Updates.push("carpetaRaiz.subcarpetas.$.archivos", archivo);

        // Ejecutar la actualización
        if (conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion).getModifiedCount() > 0) {
            return new Archivo(ID.toString(), null, nombreArchivo, "", tipo, "", 0);

        }

        return null;
    }

    public Archivo obtenerArchivoEnCarpetaRaiz(String usuarioId, String archivoId) {
        // Filtro para buscar el archivo en la carpetaRaiz del usuario
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.archivos._id", new ObjectId(archivoId))
        );

        // Campos proyectados para devolver solo el archivo específico
        Bson proyeccion = new Document("carpetaRaiz.archivos.$", 1);

        // Realizar la consulta
        Document usuario = conexionMongo.getConnection().getCollection("usuarios").find(filtro)
                .projection(proyeccion)
                .first();

        if (usuario != null) {
            // Extraer el archivo de la estructura anidada
            Document carpetaRaiz = (Document) usuario.get("carpetaRaiz");
            if (carpetaRaiz != null) {
                List<Document> archivos = (List<Document>) carpetaRaiz.get("archivos");
                if (archivos != null && !archivos.isEmpty()) {
                    return mapearDocumentoAArchivo(archivos.get(0));  // Devuelve el archivo encontrado
                }
            }
        }
        return null; // Retorna null si no se encuentra el archivo
    }

    public Archivo obtenerArchivoSubcarpeta(String usuarioId, String carpetaId, String archivoId) {
    // Filtro para buscar el archivo   la subcarpeta 
    Bson filtro = Filters.and(
            Filters.eq("_id", new ObjectId(usuarioId)),
            Filters.elemMatch("carpetaRaiz.subcarpetas", Filters.and(
                    Filters.eq("_id", new ObjectId(carpetaId)),
                    Filters.elemMatch("archivos", Filters.eq("_id", new ObjectId(archivoId)))
            ))
    );

    // Proyección para devolver solo el archivo específico en la subcarpeta
    Bson proyeccion = Projections.fields(
            Projections.elemMatch("carpetaRaiz.subcarpetas.archivos"),
            Projections.include("carpetaRaiz.subcarpetas._id")
    );

    // Realizar la consulta
    Document usuario = conexionMongo.getConnection().getCollection("usuarios").find(filtro)
            .projection(proyeccion)
            .first();

    if (usuario != null) {
        // Extraer el archivo de la estructura anidada
        Document carpetaRaiz = (Document) usuario.get("carpetaRaiz");
        if (carpetaRaiz != null) {
            List<Document> subcarpetas = (List<Document>) carpetaRaiz.get("subcarpetas");
            for (Document subcarpeta : subcarpetas) {
                if (subcarpeta.getObjectId("_id").equals(new ObjectId(carpetaId))) {
                    List<Document> archivos = (List<Document>) subcarpeta.get("archivos");
                    for (Document archivo : archivos) {
                        if (archivo.getObjectId("_id").equals(new ObjectId(archivoId))) {
                            return mapearDocumentoAArchivo(archivo);  // Devuelve el archivo encontrado
                        }
                    }
                }
            }
        }
    }
    return null; // Retorna null si no se encuentra el archivo
}

    
    
    
    
    
    
    public boolean actualizarContenidoArchivo(String usuarioId, String archivoId, String nuevoContenido) {
        // Filtro para ubicar al usuario y al archivo específico dentro de la carpetaRaiz
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.archivos._id", new ObjectId(archivoId))
        );

        // Actualización para modificar el campo "contenido" del archivo específico
        Bson actualizacion = Updates.set("carpetaRaiz.archivos.$.contenido", nuevoContenido);

        // Ejecutar la actualización
        return conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion).getModifiedCount() > 0;
    }

    public boolean actualizarArchivoSubcarpeta(String usuarioId, String carpetaId, String archivoId, String nuevoContenido) {
        // Filtro para ubicar al usuario, la subcarpeta específica, y el archivo dentro de esa subcarpeta
        Bson filtro = Filters.and(
                Filters.eq("_id", new ObjectId(usuarioId)),
                Filters.eq("carpetaRaiz.subcarpetas._id", new ObjectId(carpetaId)),
                Filters.eq("carpetaRaiz.subcarpetas.archivos._id", new ObjectId(archivoId))
        );

        // Actualización para modificar el campo "contenido" del archivo específico dentro de la subcarpeta
        Bson actualizacion = Updates.set("carpetaRaiz.subcarpetas.$[carpeta].archivos.$[archivo].contenido", nuevoContenido);

        // Configuración de filtros para arrays anidados
        UpdateOptions options = new UpdateOptions().arrayFilters(Arrays.asList(
                Filters.eq("carpeta._id", new ObjectId(carpetaId)),
                Filters.eq("archivo._id", new ObjectId(archivoId))
        ));

        // Ejecutar la actualización
        return conexionMongo.getConnection().getCollection("usuarios").updateOne(filtro, actualizacion, options).getModifiedCount() > 0;
    }

    private Archivo mapearDocumentoAArchivo(Document doc) {
        Archivo archivo = new Archivo();

        archivo.setId(doc.getObjectId("_id").toString());
        archivo.setNombre(doc.getString("nombre"));
        archivo.setContenido(doc.getString("contenido"));
        archivo.setPath(doc.getString("path"));
        archivo.setTipo(doc.getString("tipo"));

        return archivo;
    }

}
