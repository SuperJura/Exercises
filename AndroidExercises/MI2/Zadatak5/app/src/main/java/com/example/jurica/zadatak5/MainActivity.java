package com.example.jurica.zadatak5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Jurica on 7/6/2016.
 */
public class MainActivity extends Activity {

    Button btnPostavke;
    Button btnPoruka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        btnPostavke = (Button)findViewById(R.id.btnPostavke);
        btnPoruka = (Button)findViewById(R.id.btnPoruka);
        postaviTextBtnPostavke();

        btnPostavke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PostavkeActivity.class);
                startActivity(intent);
            }
        });

        btnPoruka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                String poruka = sp.getString("text", "");
                String broj = sp.getString("brojTelefona", "");
                smsManager.sendTextMessage(broj, null, poruka, null, null);
                Toast.makeText(getBaseContext(), "Poruka poslana na " + broj + " broj.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postaviTextBtnPostavke() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        StringBuilder sb = new StringBuilder();
        if (sp.contains("text")) sb.append(sp.getString("text", "")).append(" / ");
        if (sp.contains("brojTelefona")) sb.append(sp.getString("brojTelefona", ""));
        btnPostavke.setText(sb.toString());
    }
}
