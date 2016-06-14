/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.PristupStranici;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLType;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jurica
 */
public class PregledPristupaDatabase {

    public List<PristupStranici> getPristupe() {
        SQLServerDataSource ds = getDataSource();
        List<PristupStranici> output = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPristupStranicama}")) {

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
               
            if (pristup.getKorisnikId() == 0)
            {
                stmt.setNull(1, Types.INTEGER);
            }
            else
            {
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

    private SQLServerDataSource getDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setDatabaseName("JavaWebShop");
        ds.setServerName("localhost");
        ds.setUser("sa");
        ds.setPassword("SQL");

        return ds;
    }
}
