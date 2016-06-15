/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAL.KorisniciDatabase;
import DAL.LogiranjeDatabase;
import DAL.Repozitorij;
import Models.Korisnik;
import Models.loging.Prijava;
import Models.loging.PristupStranici;
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
public class KorisnikServlet extends HttpServlet {

    LogiranjeDatabase logDatabase;
    KorisniciDatabase korisniciDatabase;
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        logDatabase = Repozitorij.getLogiranjeDatabaseInstance();
        korisniciDatabase = Repozitorij.getKorisniciDatabaseInstance();
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Korisnik> sviKorisnici = Repozitorij.getKorisniciDatabaseInstance().getSveKorisnike();
        request.getSession().setAttribute("Korisnici", sviKorisnici);
        
        if (request.getParameter("pregledKorisnikId") != null) {
            int id = Integer.parseInt(request.getParameter("pregledKorisnikId"));
            List<PristupStranici> pristupi = logDatabase.getPristupe(id);
            request.getSession().setAttribute("pristupi", pristupi);
            
            List<Prijava> prijave = logDatabase.getPrijave(id);
            request.getSession().setAttribute("prijave", prijave);
            
            request.getSession().setAttribute("trenutniKorisnik", korisniciDatabase.getKorisnika(id).getKorisnickoIme());
            
        }
        response.sendRedirect("./Admin/PregledKorisnika.jsp");
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
