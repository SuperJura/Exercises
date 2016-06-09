/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Helpers.SessionHelper;
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

        String akcija = request.getParameter("action");
        int trenutnaStranica = Integer.parseInt(request.getSession().getAttribute("proizvodiTrenutnaStranica").toString());
        if (akcija.equals("next")) {
            trenutnaStranica ++;
        }
        else if (akcija.equals("prev")) {
            trenutnaStranica --;
            if (trenutnaStranica < 0) {
                trenutnaStranica = 0;
            }
        }
        int kategorijaId = Integer.parseInt(request.getSession().getAttribute("kategorijaId").toString());
        
        SessionHelper.postaviProizvodeUSession(request.getSession(), kategorijaId, trenutnaStranica);
        response.sendRedirect("/WebShop/User/Proizvodi.jsp");
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
