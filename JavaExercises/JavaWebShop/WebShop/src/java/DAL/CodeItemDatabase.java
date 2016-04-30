/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Kategorija;
import Models.Proizvod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jurica
 */
public class CodeItemDatabase implements ItemDatabase{

    private ArrayList<Kategorija> allKategorije;
    private ArrayList<Proizvod> allProizvodi;

    public CodeItemDatabase() {
        allKategorije = new ArrayList<>();
        allProizvodi = new ArrayList<>();
        
        allKategorije.add(new Kategorija(1, "Jabuke"));
        allKategorije.add(new Kategorija(2, "Kruske"));
        allKategorije.add(new Kategorija(3, "Sljive"));
        
        allProizvodi.add(new Proizvod(1, 1, "Crvena jabuka", 10, "null", "jedna crvena jabuka"));
        allProizvodi.add(new Proizvod(2, 1, "Zelena jabuka", 15, "null", "jedna zelena jabuka"));
        allProizvodi.add(new Proizvod(3, 1, "VELIKA jabuka", 20, "null", "jedna velika jabuka"));
        
        allProizvodi.add(new Proizvod(4, 2, "Zelena kruska", 10, "null", "jedna zelena kruska"));
        allProizvodi.add(new Proizvod(5, 2, "Zuta kruska", 15, "null", "jedna zuta kruska"));
        allProizvodi.add(new Proizvod(6, 2, "mala kruska", 9, "null", "jedna mala kruska"));
        
        allProizvodi.add(new Proizvod(7, 3, "Mlada sljiva", 5, "null", "jedna mlada sljiva"));
        allProizvodi.add(new Proizvod(8, 3, "Stara sljiva", 6, "null", "jedna stara sljiva"));
        allProizvodi.add(new Proizvod(9, 3, "Neka sljiva", 4, "null", "jedna neka sljiva"));
    }
    
    
    @Override
    public List<Kategorija> getAllKategorije() {
        return allKategorije;
        
    }

    @Override
    public Kategorija getKategorija(int idKategorija) {
        return allKategorije.stream().filter(x -> x.getKategorijaId() == idKategorija).findFirst().get();
    }
    
    @Override
    public List<Proizvod> getAllProizvod(int idKategorija) {
        Proizvod[] proizvodi = allProizvodi.stream().filter(x -> x.getIdKategorija() == idKategorija).toArray(Proizvod[]::new);
        return Arrays.asList(proizvodi);
    }

    @Override
    public List<Proizvod> getPopularProizvodi() {
        ArrayList<Proizvod> output = new ArrayList<>();
        output.add(allProizvodi.get(0));
        output.add(allProizvodi.get(3));
        output.add(allProizvodi.get(6));
        output.add(allProizvodi.get(8));
        
        return output;
    }    
    
    @Override
    public Proizvod getProizvod(int idProizvod) {
        return allProizvodi.stream().filter(x -> x.getProizvodId() == idProizvod).findFirst().get();
    }
}
