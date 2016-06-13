/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Proizvod;
import Models.Transakcija;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jurica
 */
public class TransakcijaDatabase {
    
    public List<Transakcija> getTransakcije(int idKorisnik) {
        SQLServerDataSource ds = getDataSource();
        List<Transakcija> output = new ArrayList<>();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTransakcije(?)}")) {
            stmt.setInt(1, idKorisnik);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                Transakcija t = new Transakcija();
                t.setKolicina(data.getInt("Kolicina"));
                t.setDatumKupnje(data.getDate("DatumKupnje"));
                t.setProizvod(data.getString("Proizvod"));
                t.setCijenaPojedinacna(data.getFloat("CijenaPojedinacna"));
                t.setTipPlacanja(data.getString("TipPlacanja"));
                output.add(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }
    
    public void insertTranaskcija(int idKorisnik, List<Transakcija> transakcije) {
        SQLServerDataSource ds = getDataSource();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertTransakcije(?, ?, ?, ?, ?)}")) {
            for (Transakcija transakcija : transakcije) {
                stmt.setInt(1, idKorisnik);
                stmt.setInt(2, transakcija.getProizvodId());
                stmt.setInt(3, transakcija.getTipPlacanjaId());
                stmt.setInt(4, transakcija.getKolicina());
                stmt.setDate(5, new Date(transakcija.getDatumKupnje().getTime()));
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private SQLServerDataSource getDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setDatabaseName("JavaWebShop");
        ds.setServerName("localhost");
        ds.setUser("sa");
        ds.setPassword("SQL");
        
        return ds;
    }
    
}
