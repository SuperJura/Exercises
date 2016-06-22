/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.ProizvodiDatabase;
import dataAccessLayer.Repozitorij;
import dataAccessLayer.TransakcijaDatabase;
import helpers.PayPalFunkcije;
import models.Korisnik;
import models.Proizvod;
import models.Transakcija;
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

    PayPalFunkcije payPalFunctions;
    TransakcijaDatabase transakcijaDatabase;
    ProizvodiDatabase proizvodiDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        payPalFunctions = new PayPalFunkcije();
        transakcijaDatabase = Repozitorij.getTransakcijeDatabaseInstance();
        proizvodiDatabase = Repozitorij.getProizvodiDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1 - gotovina 2 - paypal
        int akcija = Integer.parseInt(request.getParameter("akcija"));
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");

        if (akcija == 2) {
            String token = request.getParameter("token");
            String payerId = request.getParameter("PayerID");
            float amount = korisnik.getKosarica().getSveukupnaCijenaEuri();
            payPalFunctions.ConfirmPayment(token, payerId, amount + "");
        }
        List<Transakcija> transakcije = new ArrayList<>();
        for (int proizvodId : korisnik.getKosarica().getProizvodi().keySet()) {
            Proizvod proizvod = proizvodiDatabase.getProizvod(proizvodId);
            Transakcija transakcija = new Transakcija();
            transakcija.setKolicina(korisnik.getKosarica().getProizvodi().get(proizvodId));
            transakcija.setDatumKupnje(Calendar.getInstance(TimeZone.getDefault()).getTime());
            transakcija.setProizvodId(proizvod.getProizvodId());
            transakcija.setTipPlacanjaId(akcija);
            transakcije.add(transakcija);
        }
        transakcijaDatabase.insertTranaskcija(korisnik.getKorisnikId(), transakcije);
        korisnik.getKosarica().ocistiKosaricu();
        response.sendRedirect("./AuthKorisnik/Kupljeno.jsp");
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
