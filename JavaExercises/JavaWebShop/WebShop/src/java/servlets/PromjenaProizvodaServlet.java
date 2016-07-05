/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.ProizvodiDatabase;
import dataAccessLayer.Repozitorij;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Proizvod;

/**
 *
 * @author Jurica
 */
public class PromjenaProizvodaServlet extends HttpServlet {
    
    ProizvodiDatabase proizvodiDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        proizvodiDatabase = Repozitorij.getProizvodiDatabaseInstance();
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proizvodId = Integer.parseInt(request.getParameter("proizvodId"));
        String proizvodNaziv = request.getParameter("proizvodNaziv");
        float proizvodCijena = Float.parseFloat(request.getParameter("proizvodCijena"));
        String proizvodSlika = request.getParameter("proizvodSlika");
        String proizvodOpis = request.getParameter("proizvodOpis");
        
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvodId(proizvodId);
        proizvod.setNaziv(proizvodNaziv);
        proizvod.setCijena(proizvodCijena);
        proizvod.setSlika(proizvodSlika);
        proizvod.setOpis(proizvodOpis);
        
        proizvodiDatabase.updateProizvod(proizvod);
        request.getSession().setAttribute("headerMsg", proizvodNaziv + " uspjesno promjenjen.");
        response.sendRedirect("Kategorije?akcija=1");
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