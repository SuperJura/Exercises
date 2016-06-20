/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAL.Repozitorij;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jurica
 */
public class Kosarica {

    private Map<Integer, Integer> proizvodi;    //proizvodId, kolicina
    private float sveukupnaCijena;

    public Kosarica() {
        proizvodi = new HashMap<>();
    }
    
    public void ocistiKosaricu() {
        proizvodi.clear();
        sveukupnaCijena = 0;
    }
    
    public void addProizvod(int proizvodId, int kolicina) {
        if (proizvodi.containsKey(proizvodId)) {
            int trenutnaKolicina = proizvodi.get(proizvodId);
            trenutnaKolicina += kolicina;
            proizvodi.put(proizvodId, trenutnaKolicina);
        } else {
            proizvodi.put(proizvodId, kolicina);
        }
        setSveukupnaCijena((float) (getSveukupnaCijena() + kolicina * Repozitorij.getProizvodiDatabaseInstance().getProizvod(proizvodId).getCijena()));
    }

    public int removeProizvod(int proizvodId, int kolicina) {
        if (!proizvodi.containsKey(proizvodId)) {
            return 0;
        }
        int trenutnaKolicina = proizvodi.get(proizvodId);
        trenutnaKolicina -= kolicina;
        float cijena = 0;
        if (trenutnaKolicina <= 0) {
            cijena = proizvodi.get(proizvodId) * Repozitorij.getProizvodiDatabaseInstance().getProizvod(proizvodId).getCijena();
            proizvodi.remove(proizvodId);
            setSveukupnaCijena(getSveukupnaCijena() - cijena);
            return kolicina + trenutnaKolicina;
        } else {
            cijena = kolicina * Repozitorij.getProizvodiDatabaseInstance().getProizvod(proizvodId).getCijena();
            setSveukupnaCijena(getSveukupnaCijena() - cijena);
            proizvodi.put(proizvodId, trenutnaKolicina);
            return kolicina;
        }
    }

    public float getSveukupnaCijena() {
        return sveukupnaCijena;
    }

    public void setSveukupnaCijena(float sveukupnaCijena) {
        this.sveukupnaCijena = sveukupnaCijena;
    }
    
    public float getSveukupnaCijenaUEurima() {
        return sveukupnaCijena / 7.5f;
    }
    
    public Map<Integer, Integer> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Map<Integer, Integer> proizvodi) {
        this.proizvodi = proizvodi;
    }

}
