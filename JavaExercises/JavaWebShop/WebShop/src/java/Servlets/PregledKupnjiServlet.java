/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.KorisniciDatabase;
import dataAccessLayer.Repozitorij;
import dataAccessLayer.TransakcijaDatabase;
import models.Korisnik;
import models.Transakcija;
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
public class PregledKupnjiServlet extends HttpServlet {

    TransakcijaDatabase transakcijeDatabase;
    KorisniciDatabase korisniciDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        transakcijeDatabase = Repozitorij.getTransakcijeDatabaseInstance();
        korisniciDatabase = Repozitorij.getKorisniciDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Korisnik> sviKorisnici = Repozitorij.getKorisniciDatabaseInstance().getSveKorisnike();
        request.getSession().setAttribute("korisnici", sviKorisnici);

        if (request.getParameter("pregledKorisnikId") != null) {
            int id = Integer.parseInt(request.getParameter("pregledKorisnikId"));
            request.getSession().setAttribute("trenutniKorisnikId", id);
        }
        if (request.getSession().getAttribute("trenutniKorisnikId") != null) {
            if (request.getParameter("datumOd") == null) {
                dohvatiSveTransakcije(request);
            } else {
                String dateOd = request.getParameter("datumOd");
                String dateDo = request.getParameter("datumDo");
                dohvatiSveTransakcije(request, dateOd, dateDo);
            }
        }
        response.sendRedirect("./Admin/PregledKupnji.jsp");

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

    private void dohvatiSveTransakcije(HttpServletRequest request) {
        int id = Integer.parseInt(request.getSession().getAttribute("trenutniKorisnikId").toString());
        List<Transakcija> transakcije = transakcijeDatabase.getTransakcije(id);
        request.getSession().setAttribute("transakcije", transakcije);
        request.getSession().setAttribute("trenutniKorisnik", korisniciDatabase.getKorisnika(id).getKorisnickoIme());

    }

    private void dohvatiSveTransakcije(HttpServletRequest request, String dateOd, String dateDo) {
        int id = Integer.parseInt(request.getSession().getAttribute("trenutniKorisnikId").toString());
        dateOd += " 00:00:00";
        dateDo += " 00:00:00";
        List<Transakcija> transakcije = transakcijeDatabase.getTransakcije(id, dateOd, dateDo);
        request.getSession().setAttribute("transakcije", transakcije);
    }
}
