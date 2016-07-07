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
        
        if (request.getParameter("btnPromjena") != null) {
            odradiPromjenu(request);
        }
        if (request.getParameter("btnDodavanje") != null) {
            odradiDodavanjeProizvoda(request);
        }
        response.sendRedirect("Kategorije?akcija=1");
    }

    private void odradiPromjenu(HttpServletRequest request) throws NumberFormatException {
        Proizvod proizvod = getProizvodIzForme(request);

        proizvodiDatabase.updateProizvod(proizvod);
        request.getSession().setAttribute("headerMsg", proizvod.getNaziv() + " uspjesno promjenjen.");
    }
    
    private void odradiDodavanjeProizvoda(HttpServletRequest request) {
        Proizvod proizvod = getProizvodIzForme(request);

        proizvodiDatabase.insertProizvod(proizvod);
        request.getSession().setAttribute("headerMsg", proizvod.getNaziv() + " uspjesno dodan!");
    }

    private Proizvod getProizvodIzForme(HttpServletRequest request) {
        int proizvodId = 0;
        //ako ne ude u if, radi se o insertu novog proizvoda
        String proizvodIdParam = request.getParameter("proizvodId");
        if (proizvodIdParam != null && !proizvodIdParam.isEmpty()) {
            proizvodId = Integer.parseInt(request.getParameter("proizvodId"));
        }
         
        String proizvodNaziv = request.getParameter("proizvodNaziv");
        float proizvodCijena = Float.parseFloat(request.getParameter("proizvodCijena"));
        String proizvodSlika = request.getParameter("proizvodSlika");
        String proizvodOpis = request.getParameter("proizvodOpis");
        int idKategorija = Integer.parseInt(request.getSession().getAttribute("kategorijaId").toString());

        Proizvod proizvod = new Proizvod();
        proizvod.setIdKategorija(idKategorija);
        proizvod.setProizvodId(proizvodId);
        proizvod.setNaziv(proizvodNaziv);
        proizvod.setCijena(proizvodCijena);
        proizvod.setSlika(proizvodSlika);
        proizvod.setOpis(proizvodOpis);
        
        return proizvod;
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
