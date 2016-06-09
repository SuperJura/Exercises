/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jurica
 */
public class Kosarica {

    private Map<Integer, Integer> proizvodi;    //proizvodId, kolicina

    public Kosarica() {
        proizvodi = new HashMap<>();
    }

    /**
     * @return the proizvodi
     */
    public Map<Integer, Integer> getProizvodi() {
        return proizvodi;
    }

    /**
     * @param proizvodi the proizvodi to set
     */
    public void setProizvodi(Map<Integer, Integer> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public void addProizvod(int proizvodId, int kolicina) {
        if (proizvodi.containsKey(proizvodId)) {
            int trenutnaKolicina = proizvodi.get(proizvodId);
            trenutnaKolicina += kolicina;
            proizvodi.put(proizvodId, trenutnaKolicina);
        } else {
            proizvodi.put(proizvodId, kolicina);
        }
    }
}
