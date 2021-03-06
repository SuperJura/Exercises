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
public class ProizvodiServlet extends HttpServlet {

    ProizvodiDatabase proizvodiDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        proizvodiDatabase = Repozitorij.getProizvodiDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int kategorijaId = Integer.parseInt(request.getParameter("kategorijaId"));
        if (request.getParameter("akcija") != null) {
            int akcija = Integer.parseInt(request.getParameter("akcija"));
            if (akcija == 1) {
                posaljiAdminoveProizvode(request, kategorijaId, response);
            } else {
                posaljiKorisnikoveProizvode(request, kategorijaId, response);
            }
        } else {
            posaljiKorisnikoveProizvode(request, kategorijaId, response);
        }
    }

    private void posaljiKorisnikoveProizvode(HttpServletRequest request, int kategorijaId, HttpServletResponse response) throws IOException {
        SessionHelper.postaviProizvodeUSession(request.getSession(), kategorijaId, 0);
        request.getSession().setAttribute("kategorijaId", kategorijaId);
        request.getSession().setAttribute("kategorijaNaziv", proizvodiDatabase.getKategorija(kategorijaId).getNaziv());
        response.sendRedirect("/WebShop/Korisnik/Proizvodi.jsp");
    }

    private void posaljiAdminoveProizvode(HttpServletRequest request, int kategorijaId, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("proizvodi", proizvodiDatabase.getAllProizvod(kategorijaId));
        request.getSession().setAttribute("kategorijaId", kategorijaId);
        request.getSession().setAttribute("kategorijaNaziv", proizvodiDatabase.getKategorija(kategorijaId).getNaziv());
        response.sendRedirect("/WebShop/Admin/Proizvodi.jsp");
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
