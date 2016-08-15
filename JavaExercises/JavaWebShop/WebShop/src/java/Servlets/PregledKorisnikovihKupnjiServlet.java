/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.Repozitorij;
import dataAccessLayer.TransakcijaDatabase;
import models.Korisnik;
import models.Transakcija;
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
public class PregledKorisnikovihKupnjiServlet extends HttpServlet {

    TransakcijaDatabase transakcijaDatabase;
    
    @Override
    public void init() throws ServletException {
        super.init();
        transakcijaDatabase = Repozitorij.getTransakcijeDatabaseInstance();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
        List<Transakcija> transakcije = transakcijaDatabase.getTransakcije(korisnik.getKorisnikId());

        request.getSession().setAttribute("transakcije", transakcije);
        response.sendRedirect("/WebShop/AuthKorisnik/PregledKupnji.jsp");
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
