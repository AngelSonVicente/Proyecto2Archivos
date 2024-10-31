/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

//import com.fasterxml.jackson.databind.ObjectMapper;
import DatosBD.ConexionMongo;
import DatosBD.MongoCliente;
import DatosBD.UsuarioBD;
import Model.JsonUtil;
import Model.Usuario;
import Model.login;
import Service.LoginService;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;
import exceptions.InvalidDataException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
@WebServlet(name = "LoginController", urlPatterns = {"/v1/login"})

public class Login extends HttpServlet {

    JsonUtil jsonUtil = new JsonUtil();

    login login = new login();
    private LoginService loginService = new LoginService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    
        UsuarioBD usuario = new UsuarioBD();
        
      //  System.out.println(usuario.getUsuarioCompletoByUser("usuario5").toString());
        
        System.out.println("\n\n\n");
        
        System.out.println(System.getProperty("user.dir"));
        
        System.out.println("\n\n\n");
        
     //   usuario.agregarSubcarpeta("671f374cd1f11b35d0fe6928", "671f374cd1f11b35d0fe6923", "CarpetaNueva2");
        System.out.println(usuario.getSubcarpeta("67217f2f309fe61da7fe691a", "67217f2f309fe61da7fe6913").toString());
     
        
        
    
    }


    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Entre al servlet Login");

        String body = jsonUtil.getBody(request);
         System.out.println(body);

        try {
            loginService.procesarSolicitud(body, response);
            
            
            //loginService.procesarSolicitud(body, response);
        } catch (InvalidDataException ex) {
            
            ex.printStackTrace();
         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        
        
        }
    }

}
