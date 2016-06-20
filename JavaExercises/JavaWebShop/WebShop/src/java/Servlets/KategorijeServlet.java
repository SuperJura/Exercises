/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAL.ProizvodiDatabase;
import DAL.Repozitorij;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class KategorijeServlet extends HttpServlet {

    ProizvodiDatabase proizvodiDatabase;

    @Override
    public void init() throws ServletException {
        proizvodiDatabase = Repozitorij.getProizvodiDatabaseInstance();
        super.init();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("kategorije", proizvodiDatabase.getAllKategorije());
        response.sendRedirect("User/Kategorije.jsp");
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