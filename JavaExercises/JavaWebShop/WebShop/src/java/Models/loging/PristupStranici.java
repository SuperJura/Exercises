/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.loging;

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

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public String getIpAdresa() {
        return ipAdresa;
    }

    public void setIpAdresa(String ipAdresa) {
        this.ipAdresa = ipAdresa;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStranica() {
        return stranica;
    }

    public void setStranica(String stranica) {
        this.stranica = stranica;
    }
}
