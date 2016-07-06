/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import dataAccessLayer.Repozitorij;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class DetaljiProizvodaServlet extends HttpServlet {

    //Servlet se ponasa kao REST servis, samo vraca json za zadani ID proizvoda
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        
        Gson json = new Gson();
        String proizvodJson = json.toJson(Repozitorij.getProizvodiDatabaseInstance().getProizvod(id));
        try (PrintWriter out = response.getWriter()) {
            out.println(proizvodJson);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
