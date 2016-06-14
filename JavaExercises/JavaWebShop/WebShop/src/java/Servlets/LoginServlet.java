/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAL.KorisniciDatabase;
import DAL.Repozitorij;
import Helpers.SessionHelper;
import Models.Korisnik;
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
public class LoginServlet extends HttpServlet {

    private KorisniciDatabase database;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        database = Repozitorij.getKorisniciDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //TODO zamjeni "action" s "akcija", zamjeni "prijava/reg/odjava" s 1,2,3
            String akcija = request.getParameter("action");

            switch (akcija) {
                case "prijava":
                    doPrijava(request, response);
                    break;
                case "registracija":
                    doRegistracija(request, response);
                    break;
                case "odjava":
                    doOdjava(request, response);
                    break;
            }

        }
    }

    private void doPrijava(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String korisnickoIme = request.getParameter("txtIme");
        String lozinka = request.getParameter("txtLozinka");
        Korisnik korisnik = database.getKorisnika(korisnickoIme, lozinka);
        if (korisnik == null) {
            request.getSession().setAttribute("loginError", "Korisničko ime ili lozinka su krivi!");
            response.sendRedirect("User/Login.jsp");
        } else {
            if (request.getSession().getAttribute("Korisnik") != null) {
                Korisnik anonPodaci = (Korisnik)request.getSession().getAttribute("Korisnik");
                korisnik.setKosarica(anonPodaci.getKosarica());
            }
            request.getSession().setAttribute("Korisnik", korisnik);
            SessionHelper.postaviProizvodeUSession(request.getSession(), -1, 0);
            response.sendRedirect("User/Pocetna.jsp");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    private void doRegistracija(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String korisnickoIme = request.getParameter("txtImeReg");
        String lozinka = request.getParameter("txtLozinkaReg");

        boolean rezultat = database.insertKorisnik(korisnickoIme, lozinka, false);
        if (rezultat) {
            request.getSession().setAttribute("loginError", "Uspješno ste kreirali račun! probajte se ulogirati da provjerite podatke.");
            response.sendRedirect("User/Login.jsp");
        } else {
            request.getSession().setAttribute("loginError", "Neuspjesno kreiranje računa. Korisničko ime već postoji");
            response.sendRedirect("User/Login.jsp");
        }
    }

    private void doOdjava(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("Korisnik") != null) {
            Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
            korisnik.setAdministrator(false);
            korisnik.setKorisnickoIme(null);
        }
        response.sendRedirect("Profil");
    }
}