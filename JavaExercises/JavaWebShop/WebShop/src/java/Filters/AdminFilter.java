/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import helpers.SessionHelper;
import models.Korisnik;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jurica
 */
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getSession().getAttribute("korisnik") != null) {
            Korisnik korisnik = (Korisnik) req.getSession().getAttribute("korisnik");
            if (!korisnik.isAdministrator()) {
                posaljiNaKorisnikovuPocetnu(req, res);
            }
        } else {
            posaljiNaKorisnikovuPocetnu(req, res);
        }

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }

    private void posaljiNaKorisnikovuPocetnu(HttpServletRequest req, HttpServletResponse res) throws IOException {
        SessionHelper.postaviProizvodeUSession(req.getSession(), -1, 0);
        res.sendRedirect("/WebShop/Korisnik/Pocetna.jsp");
    }
}
