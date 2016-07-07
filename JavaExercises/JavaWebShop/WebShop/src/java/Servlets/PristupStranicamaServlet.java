/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.LogiranjeDatabase;
import dataAccessLayer.Repozitorij;
import models.loging.PristupStranici;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class PristupStranicamaServlet extends HttpServlet {

    LogiranjeDatabase logiranjeDatabase;
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        logiranjeDatabase = Repozitorij.getLogiranjeDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int kolicinaZapisa = 50;
        if (request.getParameter("kolicinaZapisa") != null) {
            kolicinaZapisa = Integer.parseInt(request.getParameter("kolicinaZapisa"));
        }
        request.getSession().setAttribute("kolicinaZapisa", kolicinaZapisa);
        
        List<PristupStranici> pristupi = logiranjeDatabase.getAllPristupe(kolicinaZapisa);   
        request.getSession().setAttribute("pristupi", pristupi);
        response.sendRedirect("/WebShop/Admin/PregledPristupaStranicama.jsp");
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
