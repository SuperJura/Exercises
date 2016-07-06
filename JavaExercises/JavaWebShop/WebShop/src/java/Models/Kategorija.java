/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
    
    public int getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(int kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
