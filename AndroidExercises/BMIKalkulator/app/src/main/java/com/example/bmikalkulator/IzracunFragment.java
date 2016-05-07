package com.example.bmikalkulator;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JuraLocal on 4.5.2016..
 */
public class IzracunFragment extends Fragment {

    EditText etTezina;
    EditText etVisina;
    Button btnIzracunaj;

    MainActivity context;

    @SuppressLint("ValidFragment")
    public IzracunFragment(MainActivity context) {
        this.context = context;
    }

    public IzracunFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.izracun_fragment_layout, null);

        this.etTezina = (EditText) view.findViewById(R.id.etTezina);
        this.etVisina = (EditText) view.findViewById(R.id.etVisina);
        this.btnIzracunaj = (Button) view.findViewById(R.id.btnIzracunaj);

        btnIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tezina = -1;
                double visina = -1;
                try
                {
                    tezina = Double.parseDouble(etTezina.getText().toString());
                }
                catch (Exception ex) {}

                try
                {
                    visina = Double.parseDouble(etVisina.getText().toString());
                }
                catch (Exception ex) {}

                MainActivity.bmi = izracunajBMI(tezina, visina);
                context.setPrikazFragment();
            }
        });

        return view;
    }

    private double izracunajBMI (double tezina, double visina)
    {
        if (tezina <= 0 || visina <= 0)
            return -1;

        // visina je unesena u centimetrima, pretvorba u metre
        if (visina >= 3)
            visina = visina / 100;

        return tezina / (visina * visina);
    }
}
