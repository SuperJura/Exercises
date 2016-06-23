/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
public class PaginationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int akcija = Integer.parseInt(request.getParameter("akcija"));
        int trenutnaStranica = Integer.parseInt(request.getSession().getAttribute("proizvodiTrenutnaStranica").toString());
        if (akcija == 1) {
            trenutnaStranica ++;
        }
        else if (akcija == 2) {
            trenutnaStranica --;
            if (trenutnaStranica < 0) {
                trenutnaStranica = 0;
            }
        }
        int kategorijaId = Integer.parseInt(request.getSession().getAttribute("kategorijaId").toString());
        SessionHelper.postaviProizvodeUSession(request.getSession(), kategorijaId, trenutnaStranica);
        response.sendRedirect("/WebShop/Korisnik/Proizvodi.jsp");
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
