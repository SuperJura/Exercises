package com.example.bmikalkulator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	FrameLayout flFragment;
	IzracunFragment izracunFragment;
	PrikazFragment prikazFragment;
	public static double bmi;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		flFragment = (FrameLayout)this.findViewById(R.id.flFragment);

		setIzracunFragment();
    }

	private void setIzracunFragment() {
		if (izracunFragment == null) izracunFragment = new IzracunFragment(this);

		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.flFragment, izracunFragment, "IF");
		ft.commit();
	}

	public void setPrikazFragment()
	{
		if (prikazFragment == null) prikazFragment = new PrikazFragment();

		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment ifrag = fm.findFragmentByTag("IF");
		ft.remove(ifrag);
		ft.add(R.id.flFragment, prikazFragment, "PF");
		ft.addToBackStack("");
		ft.commit();
		//prikazFragment.setBMI(bmi);

	}
}
