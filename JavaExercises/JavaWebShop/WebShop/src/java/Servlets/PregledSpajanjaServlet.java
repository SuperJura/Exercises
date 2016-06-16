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
public class PregledSpajanjaServlet extends HttpServlet {

    LogiranjeDatabase logDatabase;
    KorisniciDatabase korisniciDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        logDatabase = Repozitorij.getLogiranjeDatabaseInstance();
        korisniciDatabase = Repozitorij.getKorisniciDatabaseInstance();
    }

    //TODO probati napisati ljepse (s parametrima, ovo i PregledKupnjiServlet ima slicni kod - probati to u jedno staviti)
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Korisnik> sviKorisnici = Repozitorij.getKorisniciDatabaseInstance().getSveKorisnike();
        request.getSession().setAttribute("Korisnici", sviKorisnici);

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
        response.sendRedirect("./Admin/PregledSpajanja.jsp");
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
}
