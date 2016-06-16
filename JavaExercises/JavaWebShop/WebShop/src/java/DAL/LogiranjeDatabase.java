/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.loging.Prijava;
import Models.loging.PristupStranici;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jurica
 */
public class LogiranjeDatabase {

    public List<PristupStranici> getAllPristupe(int kolicina) {
        SQLServerDataSource ds = getDataSource();
        List<PristupStranici> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllPristupStranicama(?)}")) {

            stmt.setInt(1, kolicina);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                PristupStranici pristupStranici = new PristupStranici();
                pristupStranici.setKorisnikId(data.getInt("IdKorisnik"));
                pristupStranici.setKorisnik(data.getString("KorisnickoIme"));
                pristupStranici.setIpAdresa(data.getString("IpAdresa"));
                pristupStranici.setStranica(data.getString("Stranica"));
                pristupStranici.setDatum(data.getTimestamp("Datum"));
                if (pristupStranici.getKorisnik() == null) {
                    pristupStranici.setKorisnik("Anonimni korisnik");
                }
                output.add(pristupStranici);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public List<PristupStranici> getPristupe(int korisnikId) {
        SQLServerDataSource ds = getDataSource();
        List<PristupStranici> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPristupStranicamaForKorisnik(?)}")) {

            stmt.setInt(1, korisnikId);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                PristupStranici pristupStranici = new PristupStranici();
                pristupStranici.setKorisnikId(data.getInt("IdKorisnik"));
                pristupStranici.setKorisnik(data.getString("KorisnickoIme"));
                pristupStranici.setIpAdresa(data.getString("IpAdresa"));
                pristupStranici.setStranica(data.getString("Stranica"));
                pristupStranici.setDatum(data.getTimestamp("Datum"));
                if (pristupStranici.getKorisnik() == null) {
                    pristupStranici.setKorisnik("Anonimni korisnik");
                }
                output.add(pristupStranici);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public List<PristupStranici> getPristupe(int korisnikId, String datumOd, String datumDo) {
        SQLServerDataSource ds = getDataSource();
        List<PristupStranici> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPristupStranicamaForKorisnikOdDo(?, ?, ?)}")) {

            stmt.setInt(1, korisnikId);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            stmt.setDate(2, new java.sql.Date(df.parse(datumOd).getTime()));
            stmt.setDate(3, new java.sql.Date(df.parse(datumDo).getTime()));
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                PristupStranici pristupStranici = new PristupStranici();
                pristupStranici.setKorisnikId(data.getInt("IdKorisnik"));
                pristupStranici.setKorisnik(data.getString("KorisnickoIme"));
                pristupStranici.setIpAdresa(data.getString("IpAdresa"));
                pristupStranici.setStranica(data.getString("Stranica"));
                pristupStranici.setDatum(data.getTimestamp("Datum"));
                if (pristupStranici.getKorisnik() == null) {
                    pristupStranici.setKorisnik("Anonimni korisnik");
                }
                output.add(pristupStranici);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public void insertPristup(PristupStranici pristup) {
        SQLServerDataSource ds = getDataSource();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPristup(?, ?, ?, ?)}")) {

            if (pristup.getKorisnikId() == 0) {
                stmt.setNull(1, Types.INTEGER);
            } else {
                stmt.setInt(1, pristup.getKorisnikId());
            }
            stmt.setString(2, pristup.getIpAdresa());
            stmt.setString(3, pristup.getStranica());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
            stmt.setString(4, df.format(pristup.getDatum()));
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Prijava> getPrijave(int korisnikId) {
        SQLServerDataSource ds = getDataSource();
        List<Prijava> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPrijave(?)}")) {

            stmt.setInt(1, korisnikId);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                Prijava prijava = new Prijava();
                prijava.setKorisnikId(data.getInt("IdKorisnik"));
                prijava.setKorisnik(data.getString("KorisnickoIme"));
                prijava.setIpAdresa(data.getString("IpAdresa"));
                prijava.setDatum(data.getTimestamp("Datum"));
                output.add(prijava);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public List<Prijava> getPrijave(int korisnikId, String datumOd, String datumDo) {
        SQLServerDataSource ds = getDataSource();
        List<Prijava> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPrijaveOdDo(?, ?, ?)}")) {

            stmt.setInt(1, korisnikId);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            stmt.setDate(2, new java.sql.Date(df.parse(datumOd).getTime()));
            stmt.setDate(3, new java.sql.Date(df.parse(datumDo).getTime()));
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                Prijava prijava = new Prijava();
                prijava.setKorisnikId(data.getInt("IdKorisnik"));
                prijava.setKorisnik(data.getString("KorisnickoIme"));
                prijava.setIpAdresa(data.getString("IpAdresa"));
                prijava.setDatum(data.getTimestamp("Datum"));
                output.add(prijava);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    public void insertPrijavu(Prijava prijava) {
        SQLServerDataSource ds = getDataSource();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPrijave(?, ?, ?)}")) {

            stmt.setInt(1, prijava.getKorisnikId());
            stmt.setString(2, prijava.getIpAdresa());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
            stmt.setString(3, df.format(prijava.getDatum()));
            stmt.execute();
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
