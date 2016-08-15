package com.example.jurica.zadatak1;

/**
 * Created by Jurica on 7/4/2016.
 */
public class Mjesto {

    private int id;
    private String naziv;
    private int brojStanovnika;
    private int zupanijaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public int getZupanijaId() {
        return zupanijaId;
    }

    public void setZupanijaId(int zupanijaId) {
        this.zupanijaId = zupanijaId;
    }
}
