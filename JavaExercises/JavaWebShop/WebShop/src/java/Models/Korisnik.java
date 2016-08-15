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
public class Korisnik {

    private int korisnikId;
    private String korisnickoIme;
    private boolean administrator;
    private Kosarica kosarica;

    public Korisnik() {
        kosarica = new Kosarica();
        korisnickoIme = null;
        administrator = false;
        korisnikId = 0;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public Kosarica getKosarica() {
        return kosarica;
    }

    public void setKosarica(Kosarica kosarica) {
        this.kosarica = kosarica;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }
}
