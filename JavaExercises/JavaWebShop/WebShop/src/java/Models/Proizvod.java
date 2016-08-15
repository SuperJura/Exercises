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
public class Proizvod {

    private int proizvodId;
    private int idKategorija;
    private String kategorija; //nije u bazi, vec se postavlja kasnije
    private String naziv;
    private float cijena;
    private String slika;
    private String opis;

    public Proizvod(int proizvodId, int idKategorija, String naziv, float cijena, String slika, String opis, String kategorija) {
        this.proizvodId = proizvodId;
        this.idKategorija = idKategorija;
        this.naziv = naziv;
        this.cijena = cijena;
        this.slika = slika;
        this.opis = opis;
        this.kategorija = kategorija;
    }

    public Proizvod() {
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public int getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(int idKategorija) {
        this.idKategorija = idKategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
}
