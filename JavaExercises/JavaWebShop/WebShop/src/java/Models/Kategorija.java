/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Jurica
 */
public class Kategorija {
    private int kategorijaId;
    private String naziv;

    public Kategorija(int kategorijaId, String naziv) {
        this.kategorijaId = kategorijaId;
        this.naziv = naziv;
    }

    public Kategorija() {
    }
    
    /**
     * @return the kategorijaId
     */
    public int getKategorijaId() {
        return kategorijaId;
    }

    /**
     * @param kategorijaId the kategorijaId to set
     */
    public void setKategorijaId(int kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
