/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Kategorija;
import Models.Proizvod;
import java.util.List;

/**
 *
 * @author Jurica
 */
public interface ItemDatabase {
    public List<Kategorija> getAllKategorije();
    public Kategorija getKategorija(int idKategorija);
    public List<Proizvod> getAllProizvod(int idKategorija);
    public List<Proizvod> getPopularProizvodi();
    public Proizvod getProizvod(int idProizvod);
}
