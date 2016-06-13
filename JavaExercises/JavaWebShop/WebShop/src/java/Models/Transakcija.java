/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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

    /**
     * @return the datumKupnje
     */
    public Date getDatumKupnje() {
        return datumKupnje;
    }

    /**
     * @param datumKupnje the datumKupnje to set
     */
    public void setDatumKupnje(Date datumKupnje) {
        this.datumKupnje = datumKupnje;
    }

    /**
     * @return the Proizvod
     */
    public String getProizvod() {
        return proizvod;
    }

    /**
     * @param Proizvod the Proizvod to set
     */
    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }

    /**
     * @return the cijenaPojedinacna
     */
    public float getCijenaPojedinacna() {
        return cijenaPojedinacna;
    }

    /**
     * @param cijenaPojedinacna the cijenaPojedinacna to set
     */
    public void setCijenaPojedinacna(float cijenaPojedinacna) {
        this.cijenaPojedinacna = cijenaPojedinacna;
    }

    /**
     * @return the tipPlacanja
     */
    public String getTipPlacanja() {
        return tipPlacanja;
    }

    /**
     * @param nacinKupnje the tipPlacanja to set
     */
    public void setTipPlacanja(String tipPlacanja) {
        this.tipPlacanja = tipPlacanja;
    }

    /**
     * @return the tipPlacanjaId
     */
    public int getTipPlacanjaId() {
        return tipPlacanjaId;
    }

    /**
     * @param tipPlacanjaId the tipPlacanjaId to set
     */
    public void setTipPlacanjaId(int tipPlacanjaId) {
        this.tipPlacanjaId = tipPlacanjaId;
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
}
