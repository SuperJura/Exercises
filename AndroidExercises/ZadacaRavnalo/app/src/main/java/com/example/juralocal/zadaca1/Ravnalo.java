package com.example.juralocal.zadaca1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Debug;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by JuraLocal on 28.3.2016..
 */
public class Ravnalo extends View {

    private Paint paint;
    private int layoutHeight;

    public Ravnalo(Context context)
    {
        super(context);
        init();
    }

    public Ravnalo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Ravnalo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        layoutHeight = getLayoutParams().height;
        canvas.drawLine(0, 50f, Float.parseFloat(getWidth() + ""), 50f, paint);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        float duljinaMilimetra = (float)(1.0f * dm.xdpi / 25.4);

        float jedanMilimetar = 0;
        float zbrojMilimetara = 0;
        for (int i = 0; i < getWidth(); i++)
        {
            if(jedanMilimetar >= duljinaMilimetra)
            {
                if (zbrojMilimetara % 10 == 0)
                {
                    nacrtajVelikuLiniju(canvas, i, zbrojMilimetara);
                }
                else if (zbrojMilimetara % 5 == 0)
                {
                    nacrtajSrednjuLiniju(canvas, i, zbrojMilimetara);
                }
                else
                {
                    nacrtajMaluLiniju(canvas, i, zbrojMilimetara);
                }
                zbrojMilimetara += 1;
                jedanMilimetar = 0;
            }
            jedanMilimetar += 1;
        }
    }

    private void nacrtajMaluLiniju(Canvas canvas, int xVrijednost, float zbrojMilimetara) {
        canvas.drawLine(xVrijednost, 40, xVrijednost, 60, paint);
    }

    private void nacrtajSrednjuLiniju(Canvas canvas, int xVrijednost, float zbrojMilimetara) {
        canvas.drawLine(xVrijednost, 30, xVrijednost, 70, paint);
    }

    private void nacrtajVelikuLiniju(Canvas canvas,int xVrijednost, float milimetar) {
        //metoda dobiva broj u milimetrima tako da se treba podjeliti sa 10 da se dobi vrijednost za ispis
        int broj = (int) (milimetar / 10);  //pretvara se u int da nema broj.0 u ispisu
        String ispis = Integer.toString(broj);
        canvas.drawLine(xVrijednost, 20, xVrijednost, 80, paint);
        canvas.drawText(ispis, xVrijednost - 10, 110, paint);
    }
}
