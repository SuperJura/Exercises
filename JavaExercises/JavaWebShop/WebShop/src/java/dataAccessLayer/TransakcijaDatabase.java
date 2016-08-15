/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

import models.Transakcija;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
                t.setDatumKupnje(data.getTimestamp("DatumKupnje"));
                t.setProizvod(data.getString("Proizvod"));
                t.setProizvodId(data.getInt("ProizvodId"));
                t.setCijenaPojedinacna(data.getFloat("CijenaPojedinacna"));
                t.setTipPlacanja(data.getString("TipPlacanja"));
                output.add(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public List<Transakcija> getTransakcije(int idKorisnik, String datumOd, String datumDo) {
        SQLServerDataSource ds = getDataSource();
        List<Transakcija> output = new ArrayList<>();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTransakcijeOdDo(?, ?, ?)}")) {
            stmt.setInt(1, idKorisnik);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            stmt.setDate(2, new java.sql.Date(df.parse(datumOd).getTime()));
            stmt.setDate(3, new java.sql.Date(df.parse(datumDo).getTime()));
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                Transakcija t = new Transakcija();
                t.setKolicina(data.getInt("Kolicina"));
                t.setDatumKupnje(data.getTimestamp("DatumKupnje"));
                t.setProizvod(data.getString("Proizvod"));
                t.setProizvodId(data.getInt("ProizvodId"));
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
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
                stmt.setString(5, df.format(transakcija.getDatumKupnje()));
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
