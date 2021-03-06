/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

/**
 *
 * @author Jurica
 */
public class Repozitorij {

    private static ProizvodiDatabase proizvodi;
    private static KorisniciDatabase korisnici;
    private static TransakcijaDatabase transakcije;
    private static LogiranjeDatabase logiranje;

    public static ProizvodiDatabase getProizvodiDatabaseInstance() {
        if (proizvodi == null) {
            proizvodi = new ProizvodiDatabase();
        }

        return proizvodi;
    }

    public static KorisniciDatabase getKorisniciDatabaseInstance() {
        if (korisnici == null) {
            korisnici = new KorisniciDatabase();
        }

        return korisnici;
    }
    
    public static TransakcijaDatabase getTransakcijeDatabaseInstance() {
        if (transakcije == null) {
            transakcije = new TransakcijaDatabase();
        }

        return transakcije;
    }
    
    public static LogiranjeDatabase getLogiranjeDatabaseInstance() {
        if (logiranje == null) {
            logiranje = new LogiranjeDatabase();
        }

        return logiranje;
    }
}
