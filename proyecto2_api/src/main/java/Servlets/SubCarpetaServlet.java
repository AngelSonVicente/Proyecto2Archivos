/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Service.SubCarpetaService;
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
@WebServlet(name = "SubCarpetaConstroller", urlPatterns = {"/v1/SubCarpeta"})
public class SubCarpetaServlet extends HttpServlet {
    
    JsonUtil jsonUtil = new JsonUtil();
    SubCarpetaService subCarpeta = new SubCarpetaService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String codigoUsuario = request.getParameter("codigoUsuario");
        String codigoCarpeta = request.getParameter("codigoCarpeta");
        System.out.println("codigo Usuario: "+ codigoUsuario);
        System.out.println("codigo Carpeta: "+ codigoCarpeta);
        
        subCarpeta.getSubCarpeta(codigoUsuario, codigoCarpeta, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String body = jsonUtil.getBody(request);
        System.out.println(body);
        
        subCarpeta.CrearSubCarpeta(body, response);
        
        
    
        
    }
    
    
    
    
}
