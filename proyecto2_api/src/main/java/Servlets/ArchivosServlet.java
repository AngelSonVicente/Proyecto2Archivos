/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.ArchivosService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(name = "ArchivosServlet", urlPatterns = {"/v1/Archivos"})
public class ArchivosServlet extends HttpServlet {

    JsonUtil jsonUtil = new JsonUtil();
    ArchivosService archivoService = new ArchivosService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String body = jsonUtil.getBody(request);
        
        System.out.println(body);
        
        archivoService.crearArchivo(body, response);
        
        
        
        
        
        
        
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String codigoUsuario = request.getParameter("codigoUsuario");
        String codigoCarpeta = request.getParameter("codigoCarpeta");
        String codigoArchivo = request.getParameter("codigoArchivo");
        System.out.println(codigoUsuario);
        System.out.println(codigoCarpeta);
        System.out.println(codigoArchivo);
        
        archivoService.getArchivho(codigoUsuario, codigoCarpeta, codigoArchivo, response);
        
        
        
        
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        
        String body = jsonUtil.getBody(request);
        
        System.out.println(body);
        
        
        archivoService.ActualizarArchivo(body, response);
        
        
        
    
    
    }
    
    

    
}
