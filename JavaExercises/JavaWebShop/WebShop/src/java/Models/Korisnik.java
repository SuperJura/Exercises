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
    
    

    /**
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * @return the administrator
     */
    public boolean isAdministrator() {
        return administrator;
    }

    /**
     * @param administrator the administrator to set
     */
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    /**
     * @return the kosarica
     */
    public Kosarica getKosarica() {
        return kosarica;
    }

    /**
     * @param kosarica the kosarica to set
     */
    public void setKosarica(Kosarica kosarica) {
        this.kosarica = kosarica;
    }

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
}
