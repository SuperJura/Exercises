package com.example.jurica.zadatak3;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Jurica on 7/4/2016.
 */
public class ActivityA extends Activity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("naziv", "ActivityA");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
