/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.loging;

import java.util.Date;

/**
 *
 * @author Jurica
 */
public class PristupStranici{
    private int korisnikId;
    private String korisnik;
    private String ipAdresa;
    private Date datum;
    private String stranica;

    /**
     * @return the korisnikId
     */
    public int getKorisnikId() {
        return korisnikId;
    }

    /**
     * @param korisnikId the korisnikId to set
     */
    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    /**
     * @return the korisnik
     */
    public String getKorisnik() {
        return korisnik;
    }

    /**
     * @param korisnik the korisnik to set
     */
    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * @return the ipAdresa
     */
    public String getIpAdresa() {
        return ipAdresa;
    }

    /**
     * @param ipAdresa the ipAdresa to set
     */
    public void setIpAdresa(String ipAdresa) {
        this.ipAdresa = ipAdresa;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the stranica
     */
    public String getStranica() {
        return stranica;
    }

    /**
     * @param stranica the stranica to set
     */
    public void setStranica(String stranica) {
        this.stranica = stranica;
    }
}
