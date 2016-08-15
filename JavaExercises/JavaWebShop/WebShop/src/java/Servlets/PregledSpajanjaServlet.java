/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.KorisniciDatabase;
import dataAccessLayer.LogiranjeDatabase;
import dataAccessLayer.Repozitorij;
import models.Korisnik;
import models.loging.Prijava;
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
public class PregledSpajanjaServlet extends HttpServlet {

    LogiranjeDatabase logDatabase;
    KorisniciDatabase korisniciDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        logDatabase = Repozitorij.getLogiranjeDatabaseInstance();
        korisniciDatabase = Repozitorij.getKorisniciDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Korisnik> sviKorisnici = korisniciDatabase.getSveKorisnike();
        request.getSession().setAttribute("korisnici", sviKorisnici);

        if (request.getParameter("pregledKorisnikId") != null) {
            int id = Integer.parseInt(request.getParameter("pregledKorisnikId"));
            request.getSession().setAttribute("trenutniKorisnikId", id);
        }
        if (request.getSession().getAttribute("trenutniKorisnikId") != null) {

            if (request.getParameter("datumOd") == null) {
                dohvatiSvaLogiranja(request);
            } else {
                String dateOd = request.getParameter("datumOd");
                String dateDo = request.getParameter("datumDo");
                dohvatiSvaLogiranja(request, dateOd, dateDo);
            }
        }
        response.sendRedirect("/WebShop/Admin/PregledSpajanja.jsp");
    }

    private void dohvatiSvaLogiranja(HttpServletRequest request) {
        int id = Integer.parseInt(request.getSession().getAttribute("trenutniKorisnikId").toString());
        List<PristupStranici> pristupi = logDatabase.getPristupe(id);
        request.getSession().setAttribute("pristupi", pristupi);

        List<Prijava> prijave = logDatabase.getPrijave(id);
        request.getSession().setAttribute("prijave", prijave);
        request.getSession().setAttribute("trenutniKorisnik", korisniciDatabase.getKorisnika(id).getKorisnickoIme());
    }

    private void dohvatiSvaLogiranja(HttpServletRequest request, String dateOd, String dateDo) {
        int id = Integer.parseInt(request.getSession().getAttribute("trenutniKorisnikId").toString());
        dateOd += " 00:00:00";
        dateDo += " 00:00:00";
        List<PristupStranici> pristupi = logDatabase.getPristupe(id, dateOd, dateDo);
        request.getSession().setAttribute("pristupi", pristupi);

        List<Prijava> prijave = logDatabase.getPrijave(id, dateOd, dateDo);
        request.getSession().setAttribute("prijave", prijave);
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