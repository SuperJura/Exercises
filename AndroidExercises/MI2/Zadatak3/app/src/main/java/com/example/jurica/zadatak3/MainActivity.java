package com.example.jurica.zadatak3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Jurica on 7/4/2016.
 */
public class MainActivity extends Activity {

    TextView tvIspis;
    Button btn;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        tvIspis = (TextView)findViewById(R.id.tvIspis);
        btn = (Button)findViewById(R.id.btn);
        random = new Random();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = random.nextInt(3);

                switch (index){
                    case 0:
                        callActivity(ActivityA.class);
                        break;
                    case 1:
                        callActivity(ActivityB.class);
                        break;
                    case 2:
                        callActivity(ActivityC.class);
                        break;
                }

            }
        });

    }

    public void callActivity(Class cls){
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String naziv = data.getStringExtra("naziv");
        tvIspis.setText(naziv);
    }
}
