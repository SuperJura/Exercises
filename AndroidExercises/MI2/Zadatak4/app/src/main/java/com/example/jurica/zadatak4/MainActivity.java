package com.example.jurica.zadatak4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Jurica on 7/5/2016.
 */
public class MainActivity extends Activity{

    TextView tvIspis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);
        tvIspis = (TextView)findViewById(R.id.tvIspis);

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                tvIspis.setText(intent.getIntExtra("Fibonaccijev_broj", 1) + "");
            }
        }, new IntentFilter("akcija_Fibonaccijev_broj"));

        Intent intent = new Intent(this, FibServis.class);
        intent.putExtra("ulazni_broj", 10);
        startService(intent);

    }
}
