/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Jurica
 */
public class Transakcija {
    private int kolicina;
    private Date datumKupnje;
    private int proizvodId;
    private String proizvod;
    private float cijenaPojedinacna;
    private int tipPlacanjaId;
    private String tipPlacanja;

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Date getDatumKupnje() {
        return datumKupnje;
    }

    public void setDatumKupnje(Date datumKupnje) {
        this.datumKupnje = datumKupnje;
    }

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }

    public float getCijenaPojedinacna() {
        return cijenaPojedinacna;
    }

    public void setCijenaPojedinacna(float cijenaPojedinacna) {
        this.cijenaPojedinacna = cijenaPojedinacna;
    }

    public String getTipPlacanja() {
        return tipPlacanja;
    }

    public void setTipPlacanja(String tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
    }

    public int getTipPlacanjaId() {
        return tipPlacanjaId;
    }

    public void setTipPlacanjaId(int tipPlacanjaId) {
        this.tipPlacanjaId = tipPlacanjaId;
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }
}
