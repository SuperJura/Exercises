package com.example.bmikalkulator;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JuraLocal on 4.5.2016..
 */
public class PrikazFragment extends Fragment {

    TextView tvBMI;
    TextView tvOpis;
    ImageView ivBMI;
    Drawable dSretan;
    Drawable dTuzan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prikaz_fragment_layout, null);

        this.tvBMI = (TextView) view.findViewById(R.id.tvBMI);
        this.tvOpis = (TextView) view.findViewById(R.id.tvOpis);
        this.ivBMI = (ImageView) view.findViewById(R.id.ivBMI);

        this.dSretan = view.getResources().getDrawable(R.drawable.sretan);
        this.dTuzan = view.getResources().getDrawable(R.drawable.tuzan);
        setBMI();
        return  view;
    }

    private void setBMI()
    {
        double bmi = MainActivity.bmi;
        if (bmi == -1)
        {
            tvBMI.setText("");
            tvOpis.setText("");
            ivBMI.setImageDrawable(null);
        }
        else
        {
            tvBMI.setText(String.format("%.1f", bmi));
            if (bmi <= 20)
            {
                tvOpis.setText(getResources().getString(R.string.text_pothranjeno));
                ivBMI.setBackground(dTuzan);
            }
            else if (bmi <= 25)
            {
                tvOpis.setText(getResources().getString(R.string.text_normalno));
                ivBMI.setBackground(dSretan);
            }
            else
            {
                tvOpis.setText(getResources().getString(R.string.text_prekomjerno));
                ivBMI.setBackground(dTuzan);
            }
        }
    }
}
