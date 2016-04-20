/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Kategorija;
import Models.Proizvod;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jurica
 */
public class SQLItemDatabase implements ItemDatabase{

    List<Kategorija> allKategorije;
    Map<Integer, ArrayList<Proizvod>> allProizvodi;

    public SQLItemDatabase() {
        allKategorije = new ArrayList<>();
        allProizvodi = new HashMap<>();
        FillKategorije();
    }
    
    
    
    @Override
    public List<Kategorija> getAllKategorije() {
        return allKategorije;
    }

    @Override
    public synchronized List<Proizvod> getAllProizvod(int idKategorija) {
        if (!allProizvodi.containsKey(idKategorija)) {
            FillProizvode(idKategorija);
        }
        return allProizvodi.get(idKategorija);
        
    }

    @Override
    public List<Proizvod> getPopularProizvodi() {
        ArrayList<Proizvod> output = new ArrayList<>();
        output.add(getAllProizvod(1).get(0));
        output.add(getAllProizvod(2).get(0));
        output.add(getAllProizvod(3).get(0));
        output.add(getAllProizvod(4).get(0));
        output.add(getAllProizvod(5).get(0));
        
        return output;
    }
    
    private void FillKategorije() {
        SQLServerDataSource ds = getDataSource();
        try (Connection con = ds.getConnection();
            CallableStatement stmt = con.prepareCall("{CALL getAllKategorije}")){
            ResultSet data = stmt.executeQuery();
            while(data.next())
            {
                Kategorija kat = new Kategorija();
                kat.setKategorijaId(data.getInt("KategorijaID"));
                kat.setNaziv(data.getString("Naziv"));
                allKategorije.add(kat);
            }
            
        } catch (Exception e) {
        }
    }
    
    private SQLServerDataSource getDataSource()
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setDatabaseName("JavaWebShop");
        ds.setServerName("localhost");
        ds.setUser("sa");
        ds.setPassword("SQL");
        
        return ds;
    }

    private void FillProizvode(int idKategorija) {
        SQLServerDataSource ds = getDataSource();
        try (Connection con = ds.getConnection();
            CallableStatement stmt = con.prepareCall("{CALL getAllProizvodi(?)}")){
            stmt.setInt(1, idKategorija);
            allProizvodi.put(idKategorija, new ArrayList<>());
            ResultSet data = stmt.executeQuery();
            while(data.next())
            {
                Proizvod p = new Proizvod();
                p.setProizvodId(data.getInt("ProizvodID"));
                p.setIdKategorija(data.getInt("IDKategorija"));
                p.setNaziv(data.getString("Naziv"));
                p.setCijena(data.getFloat("Cijena"));
                p.setSlika(data.getString("Slika"));
                p.setOpis(data.getString("Opis"));
                allProizvodi.get(idKategorija).add(p);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
