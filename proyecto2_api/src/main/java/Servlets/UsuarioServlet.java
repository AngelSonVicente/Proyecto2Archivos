/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.JsonUtil;
import Model.Usuario;
import Service.UsuarioService;
import exceptions.InvalidDataException;
import exceptions.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/v1/Usuario"})
public class UsuarioServlet extends HttpServlet {

    JsonUtil jsonUtil = new JsonUtil<Usuario>();

    UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("user");
        
        System.out.println("UsuarioGet: " +usuario);
        try {
            usuarioService.getUsuario(usuario, response);
            
            

        } catch (Exception e) {
            e.printStackTrace();
             response.setStatus(HttpServletResponse.SC_NOT_FOUND);


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("----------------Entramos al servlet Crear Usuario-----------------------");

        String bosy = jsonUtil.getBody(request);

        try {
            usuarioService.CrearUsuario(bosy, response);
        } catch (SQLException | InvalidDataException ex) {

            ex.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

}
