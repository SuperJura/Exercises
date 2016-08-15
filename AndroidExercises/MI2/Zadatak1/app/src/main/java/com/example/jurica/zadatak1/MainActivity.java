package com.example.jurica.zadatak1;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Jurica on 7/4/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentResolver cr = getContentResolver();
        String type = cr.getType(Uri.parse("content://com.example.mjesto/mjesto/5"));

        Toast.makeText(this, type, Toast.LENGTH_SHORT).show();
    }
}
