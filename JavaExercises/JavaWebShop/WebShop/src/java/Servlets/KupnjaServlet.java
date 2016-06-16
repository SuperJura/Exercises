/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAL.ProizvodiDatabase;
import DAL.Repozitorij;
import Models.Korisnik;
import Models.Proizvod;
import Models.Transakcija;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class KupnjaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1 - gotovina 2 - paypal
        int akcija = Integer.parseInt(request.getParameter("akcija"));
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("Korisnik");
        ProizvodiDatabase database = Repozitorij.getProizvodiDatabaseInstance();

        List<Transakcija> transakcije = new ArrayList<>();
        for (int proizvodId : korisnik.getKosarica().getProizvodi().keySet()) {
            Proizvod proizvod = database.getProizvod(proizvodId);
            Transakcija transakcija = new Transakcija();
            transakcija.setKolicina(korisnik.getKosarica().getProizvodi().get(proizvodId));
            transakcija.setDatumKupnje(Calendar.getInstance(TimeZone.getDefault()).getTime());
            transakcija.setProizvodId(proizvod.getProizvodId());
            transakcija.setTipPlacanjaId(akcija);
            transakcije.add(transakcija);
        }
        Repozitorij.getTransakcijeDatabaseInstance().insertTranaskcija(korisnik.getKorisnikId(), transakcije);
        korisnik.getKosarica().getProizvodi().clear();
        response.sendRedirect("./LogInUser/Kupljeno.jsp");
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
