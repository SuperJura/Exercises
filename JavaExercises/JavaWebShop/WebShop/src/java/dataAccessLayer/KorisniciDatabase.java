/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

import models.Korisnik;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Jurica
 */
public class KorisniciDatabase {

    public Korisnik getKorisnika(String korisnickoIme, String lozinka) {
        Korisnik korisnik = null;
        DataSource ds = getDataSource();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getUser(?, ?)}")) {
            stmt.setString(1, korisnickoIme);
            stmt.setString(2, lozinka);
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                korisnik = new Korisnik();
                korisnik.setKorisnickoIme(data.getString("KorisnickoIme"));
                korisnik.setAdministrator(data.getBoolean("Administrator"));
                korisnik.setKorisnikId(data.getInt("KorisnikId"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return korisnik;
    }

    public Korisnik getKorisnika(int id) {
        Korisnik korisnik = null;
        DataSource ds = getDataSource();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getUserForId(?)}")) {
            stmt.setInt(1, id);
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                korisnik = new Korisnik();
                korisnik.setKorisnickoIme(data.getString("KorisnickoIme"));
                korisnik.setAdministrator(data.getBoolean("Administrator"));
                korisnik.setKorisnikId(data.getInt("KorisnikId"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return korisnik;
    }
    
    public List<Korisnik> getSveKorisnike() {
        List<Korisnik> output = new ArrayList<>();
        DataSource ds = getDataSource();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllUser}")) {
            ResultSet data = stmt.executeQuery();
            while(data.next()) {
                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnickoIme(data.getString("KorisnickoIme"));
                korisnik.setAdministrator(data.getBoolean("Administrator"));
                korisnik.setKorisnikId(data.getInt("KorisnikId"));
                
                output.add(korisnik);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return output;
    }

    public boolean isAdministrator(String korisnickoIme) {
        boolean output = false;
        DataSource ds = getDataSource();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL isAdmin(?, ?)}")) {
            stmt.setString(1, korisnickoIme);
            stmt.setBoolean(2, output);
            stmt.execute();

            output = stmt.getBoolean("isAdmin");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return output;
    }

    public boolean insertKorisnik(String korisnickoIme, String lozinka, boolean isAdmin) {
        SQLServerDataSource ds = getDataSource();
        
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL createUser(?,?,?)}")){
            stmt.setString("username", korisnickoIme);
            stmt.setString("password", lozinka);
            stmt.setBoolean("isAdmin", isAdmin);
            
            stmt.execute();
            return true;
        } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
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
