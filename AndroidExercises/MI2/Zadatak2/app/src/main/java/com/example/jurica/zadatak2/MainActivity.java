package com.example.jurica.zadatak2;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Jurica on 7/4/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        TextView tvIspis = (TextView)findViewById(R.id.tvIspis);

        ContentResolver cr = getContentResolver();
        Cursor stavke = cr.query(Uri.parse("content://com.ispit.primjer/stavka"), new String[]{"Kolicina", "Cijema"}, null, null, null);
        Cursor racuni = cr.query(Uri.parse("content://com.ispit.primjer/racun"), new String[]{"ID"}, null, null, null);

        int ukupnaCijena = 0;
        int kolicinaRacuna = 0;

        try {
            while (stavke.moveToNext()) {
                int kolicina = stavke.getInt(stavke.getColumnIndex("Kolicina"));
                int cijena = stavke.getInt(stavke.getColumnIndex("Cijena"));

                int umnozak = kolicina * cijena;
                ukupnaCijena += umnozak;
            }
            while (racuni.moveToNext()) {
                kolicinaRacuna++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Ukupna cijena: " + ukupnaCijena + "\n");
        sb.append("Kolicina racuna: " + kolicinaRacuna);

        tvIspis.setText(sb.toString());
    }
}
