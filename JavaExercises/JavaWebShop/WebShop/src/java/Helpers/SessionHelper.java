/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import DAL.ProizvodiDatabase;
import DAL.Repozitorij;
import Models.Proizvod;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jurica
 */
public class SessionHelper {

    public static int proizvodiPoStranici = 5;

    //ako se traze popularni proizvodi, kategorijaId je -1
    public static void postaviProizvodeUSession(HttpSession session, int kategorijaId, int trenutnaStranica) {
        List<Proizvod> odabraniProizvodi = null;
        ProizvodiDatabase database = Repozitorij.getProizvodiDatabaseInstance();
        List<Proizvod> sviProizvodi = null;

        if (kategorijaId == -1) {
            sviProizvodi = database.getPopularProizvodi();
        } else {
            sviProizvodi = database.getAllProizvod(kategorijaId);
        }

        int indexPrvog = trenutnaStranica * proizvodiPoStranici;

        int indexZadnjeg = (trenutnaStranica * proizvodiPoStranici) + proizvodiPoStranici;

        if (indexPrvog >= sviProizvodi.size()) {
            indexPrvog -= proizvodiPoStranici;
            indexZadnjeg -= proizvodiPoStranici;
            trenutnaStranica--;
        }
        if (indexZadnjeg > sviProizvodi.size()) {
            indexZadnjeg = sviProizvodi.size();
        }
        odabraniProizvodi = sviProizvodi.subList(indexPrvog, indexZadnjeg);

        session.setAttribute("proizvodi", odabraniProizvodi);
        session.setAttribute("proizvodiTrenutnaStranica", trenutnaStranica);

    }
}
