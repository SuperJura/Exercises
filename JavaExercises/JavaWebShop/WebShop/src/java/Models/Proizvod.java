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
public class Proizvod {
    private int proizvodId;
    private int idKategorija;
    private String kategorija; //nije u bazi, vec se postavlja kasnije
    private String naziv;
    //TODO bolji prikaz cjena na jsp-ovima
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
     * @return the idKategorija
     */
    public int getIdKategorija() {
        return idKategorija;
    }

    /**
     * @param idKategorija the idKategorija to set
     */
    public void setIdKategorija(int idKategorija) {
        this.idKategorija = idKategorija;
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

    /**
     * @return the cijena
     */
    public float getCijena() {
        return cijena;
    }

    /**
     * @param cijena the cijena to set
     */
    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    /**
     * @return the slika
     */
    public String getSlika() {
        return slika;
    }

    /**
     * @param slika the slika to set
     */
    public void setSlika(String slika) {
        this.slika = slika;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the kategorija
     */
    public String getKategorija() {
        return kategorija;
    }

    /**
     * @param kategorija the kategorija to set
     */
    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
}
