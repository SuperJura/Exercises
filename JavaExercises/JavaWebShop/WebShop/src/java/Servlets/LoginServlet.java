/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.KorisniciDatabase;
import dataAccessLayer.Repozitorij;
import models.Korisnik;
import models.loging.Prijava;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class LoginServlet extends HttpServlet {

    private KorisniciDatabase korisniciDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        korisniciDatabase = Repozitorij.getKorisniciDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String akcija = request.getParameter("akcija");
        switch (akcija) {
            case "1":
                doPrijava(request, response);
                break;
            case "2":
                doRegistracija(request, response);
                break;
            case "3":
                doOdjava(request, response);
                break;
        }
    }

    private void doPrijava(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String korisnickoIme = request.getParameter("txtIme");
        String lozinka = request.getParameter("txtLozinka");
        Korisnik korisnik = korisniciDatabase.getKorisnika(korisnickoIme, lozinka);
        if (korisnik == null) {
            request.getSession().setAttribute("loginError", "Korisničko ime ili lozinka su krivi!");
            response.sendRedirect("/WebShop/Korisnik/Login.jsp");
        } else {
            if (request.getSession().getAttribute("korisnik") != null) {
                Korisnik anonPodaci = (Korisnik) request.getSession().getAttribute("korisnik");
                korisnik.setKosarica(anonPodaci.getKosarica());
            }
            request.getSession().setAttribute("korisnik", korisnik);
            logirajPrijavu(korisnik, request.getLocalAddr());
            response.sendRedirect("Pocetna");

        }
    }

    private void doRegistracija(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String korisnickoIme = request.getParameter("txtImeReg");
        String lozinka = request.getParameter("txtLozinkaReg");

        boolean rezultat = korisniciDatabase.insertKorisnik(korisnickoIme, lozinka, false);
        if (rezultat) {
            request.getSession().setAttribute("loginError", "Uspješno ste kreirali račun! probajte se ulogirati da provjerite podatke.");
            response.sendRedirect("/WebShop/Korisnik/Login.jsp");
        } else {
            request.getSession().setAttribute("loginError", "Neuspjesno kreiranje računa. Korisničko ime već postoji");
            response.sendRedirect("/WebShop/Korisnik/Login.jsp");
        }
    }

    private void doOdjava(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("korisnik") != null) {
            Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
            korisnik.setAdministrator(false);
            korisnik.setKorisnickoIme(null);
            korisnik.setKorisnikId(0);
        }
        response.sendRedirect("Profil");
    }

    private void logirajPrijavu(Korisnik korisnik, String localAddr) {
        Prijava prijava = new Prijava();
        prijava.setDatum(Calendar.getInstance(TimeZone.getDefault()).getTime());
        prijava.setIpAdresa(localAddr);
        prijava.setKorisnikId(korisnik.getKorisnikId());

        Repozitorij.getLogiranjeDatabaseInstance().insertPrijavu(prijava);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
