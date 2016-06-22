/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.math.BigDecimal;

/**
 *
 * @author Jurica
 */
public class FloatFunkcije {
    
    public static float getCijena(float cijena, int mjesta) {
        BigDecimal bd = new BigDecimal(Float.toString(cijena));
        bd = bd.setScale(mjesta, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
