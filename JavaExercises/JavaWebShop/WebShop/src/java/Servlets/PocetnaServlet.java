/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.ProizvodiDatabase;
import dataAccessLayer.Repozitorij;
import helpers.SessionHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class PocetnaServlet extends HttpServlet {

    ProizvodiDatabase database;

    @Override
    public void init() throws ServletException {
        database = Repozitorij.getProizvodiDatabaseInstance();
        super.init();
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionHelper.postaviProizvodeUSession(request.getSession(), -1, 0);
        response.sendRedirect("./Korisnik/Pocetna.jsp");
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
