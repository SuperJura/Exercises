/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Korisnik;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class KosaricaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int proizvodId = Integer.parseInt(request.getParameter("id"));
        int kolicina = Integer.parseInt(request.getParameter("kolicina"));
        int akcija = Integer.parseInt(request.getParameter("akcija"));

        Korisnik korisnik = null;
        if (request.getSession().getAttribute("korisnik") == null) {
            korisnik = new Korisnik();
            request.getSession().setAttribute("korisnik", korisnik);
        } else {
            korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
        }
        switch (akcija) {
            case 1:
                dodajProizvod(korisnik, proizvodId, kolicina, request);
                response.sendRedirect("./Profil");
                break;
            case 2:
                makniProizvod(korisnik, proizvodId, kolicina, request);
                response.sendRedirect("./Profil");
                break;
            default:
                response.sendRedirect("User/Pocetna.jsp");
        }
    }

    private void makniProizvod(Korisnik korisnik, int proizvodId, int kolicina, HttpServletRequest request) {
        int maknuto = korisnik.getKosarica().removeProizvod(proizvodId, kolicina);
        request.getSession().setAttribute("headerMsg", "Kolicina maknutih proizvoda iz kosarice: " + maknuto);
    }

    private void dodajProizvod(Korisnik korisnik, int proizvodId, int kolicina, HttpServletRequest request) {
        korisnik.getKosarica().addProizvod(proizvodId, kolicina);
        request.getSession().setAttribute("headerMsg", "Kolicina novih proizvoda u kosarici: " + kolicina);
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
