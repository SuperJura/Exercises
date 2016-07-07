package com.example.juralocal.postavke;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PostavkeFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.postavke);
    }
}
