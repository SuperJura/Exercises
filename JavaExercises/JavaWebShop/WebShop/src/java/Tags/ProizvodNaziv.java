/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import dataAccessLayer.ProizvodiDatabase;
import dataAccessLayer.Repozitorij;
import models.Proizvod;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Jurica
 */
public class ProizvodNaziv extends BodyTagSupport {

    private PageContext pageContext;
    private int proizvodId;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getProizvodNaziv());
        } catch (IOException ex) {
            Logger.getLogger(ProizvodNaziv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return EVAL_BODY_BUFFERED;
    }

    private String getProizvodNaziv()
    {
        ProizvodiDatabase database = Repozitorij.getProizvodiDatabaseInstance();
        StringBuilder stringBuilder = new StringBuilder();
        Proizvod proizvod = database.getProizvod(proizvodId);
        stringBuilder.append(proizvod.getNaziv()).append(" (kategorija: ");
        stringBuilder.append(proizvod.getKategorija()).append(")");
        
        return stringBuilder.toString();
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }
    
    public PageContext getPageContext() {
        return pageContext;
    }
    
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
}
