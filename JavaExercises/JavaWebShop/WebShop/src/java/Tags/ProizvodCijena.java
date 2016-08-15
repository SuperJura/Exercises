/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import dataAccessLayer.Repozitorij;
import helpers.FloatFunkcije;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Jurica
 */
public class ProizvodCijena extends BodyTagSupport {

    private PageContext pageContext;
    private int proizvodId;
    private int kolicina;

    @Override
    public int doStartTag() throws JspException {
        float cijena = Repozitorij.getProizvodiDatabaseInstance().getProizvod(proizvodId).getCijena();
        float ukupnaCijena = kolicina * cijena;

        try {
            pageContext.getOut().print("Cijena jednoga: <br/>" + "Cijena x " + kolicina + "</td>");
            pageContext.getOut().print("<td> <span class='boldBlack'>" + FloatFunkcije.getCijena(cijena, 2) + " KN</br>" + FloatFunkcije.getCijena(ukupnaCijena, 2) + " KN</span>");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return EVAL_BODY_BUFFERED;
    }

    /**
     * @return the pageContext
     */
    public PageContext getPageContext() {
        return pageContext;
    }

    /**
     * @param pageContext the pageContext to set
     */
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    /**
     * @return the proizvodId
     */
    public int getProizvodId() {
        return proizvodId;
    }

    /**
     * @param proizvodId the proizvodId to set
     */
    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    /**
     * @return the kolicina
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * @param kolicina the kolicina to set
     */
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

}
