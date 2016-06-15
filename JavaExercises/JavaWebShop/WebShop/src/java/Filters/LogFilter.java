/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import DAL.Repozitorij;
import Models.Korisnik;
import Models.loging.PristupStranici;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
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
public class LogFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        
        
        
        int korisnikId = 0;
        if (req.getSession().getAttribute("Korisnik") != null) {
            korisnikId = ((Korisnik) req.getSession().getAttribute("Korisnik")).getKorisnikId();
        }
        PristupStranici pristup = new PristupStranici();
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        pristup.setDatum(cal.getTime());
        pristup.setIpAdresa(req.getRemoteAddr());
        pristup.setKorisnikId(korisnikId);
        pristup.setStranica(req.getRequestURI());
        Repozitorij.getLogiranjeDatabaseInstance().insertPristup(pristup);

        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}
