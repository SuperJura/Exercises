package com.example.jurica.zadatak4;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Jurica on 7/5/2016.
 */
public class FibServis extends IntentService {

    public FibServis(){
        super("FibServis");
    }

    public FibServis(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int broj = intent.getIntExtra("ulazni_broj", 1);

        int output = izracunajFibBroj(broj);

        Intent outIntent = new Intent("akcija_Fibonaccijev_broj");
        outIntent.putExtra("Fibonaccijev_broj", output);

        LocalBroadcastManager.getInstance(FibServis.this).sendBroadcast(outIntent);
        //sendBroadcast(outIntent);
    }

    private int izracunajFibBroj(int broj) {
        if (broj < 2) return broj;

        return izracunajFibBroj(broj - 1) + izracunajFibBroj(broj - 2);
    }
}
