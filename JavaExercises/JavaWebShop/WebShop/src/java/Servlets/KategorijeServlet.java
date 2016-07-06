/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccessLayer.ProizvodiDatabase;
import dataAccessLayer.Repozitorij;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class KategorijeServlet extends HttpServlet {

    ProizvodiDatabase proizvodiDatabase;

    @Override
    public void init() throws ServletException {
        super.init();
        proizvodiDatabase = Repozitorij.getProizvodiDatabaseInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("kategorije", proizvodiDatabase.getAllKategorije());
        if (request.getParameter("akcija") != null) {
            int akcija = Integer.parseInt(request.getParameter("akcija"));
            if (akcija == 1) {
                response.sendRedirect("/WebShop/Admin/Kategorije.jsp");
            } else {
                response.sendRedirect("/WebShop/Korisnik/Kategorije.jsp");
            }
        } else {
            response.sendRedirect("/WebShop/Korisnik/Kategorije.jsp");
        }
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
