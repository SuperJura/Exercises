package com.example.juralocal.postavke;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JuraLocal on 9.6.2016..
 */
public class PocetnaAktivnost extends Activity {

    public static int REQ = 1;
    private TextView tvImePrikaz;
    private TextView tvLokacijaPrikaz;
    private TextView tvSpolPrikaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        this.setContentView(R.layout.activity_pocetna);
        tvImePrikaz = (TextView)findViewById(R.id.tvImePrikaz);
        tvLokacijaPrikaz = (TextView)findViewById(R.id.tvLokacijaPrikaz);
        tvSpolPrikaz = (TextView)findViewById(R.id.tvSpolPrikaz);
        ActionBar actionBar = this.getActionBar();

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("dz3");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.meni, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnOsvjezi)
        {
            ispisiPodatke();
            return true;
        }
        if (item.getItemId() == R.id.btnUredi)
        {
            Intent intent = new Intent(this, PostavkeAktivnost.class);
            startActivityForResult(intent, REQ);
            return true;
        }
        if (item.getItemId() == R.id.btnObrisi)
        {
            obrisiPodatke();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void obrisiPodatke() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = prefs.edit();

        edit.remove("ime");
        edit.remove("listaLokacija");
        edit.remove("spol");
        edit.commit();
    }

    private void ispisiPodatke() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        tvImePrikaz.setText(prefs.getString("ime", ""));
        int lokacijaIndex = Integer.parseInt(prefs.getString("listaLokacija", "1") + "") - 1;
        tvLokacijaPrikaz.setText(getResources().getTextArray(R.array.lista_lokacija)[lokacijaIndex]);
        tvSpolPrikaz.setText(getSpol(prefs.getBoolean("spol", false)));
    }

    private String getSpol(boolean spol){
        if (spol) return "Zensko";
        else return "Musko";
    }
}

