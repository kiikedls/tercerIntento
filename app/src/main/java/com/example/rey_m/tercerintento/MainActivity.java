package com.example.rey_m.tercerintento;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    int contador = 0;
    TextView d;
    TextView lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn);
        lbl = findViewById(R.id.lbl1);
        d=findViewById(R.id.texdone);

        View.OnClickListener clickbtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                lbl.setText("Clicks: " + String.valueOf(contador));
            }
        };

        btn1.setOnClickListener(clickbtn);

        new CountDownTimer(20000, 750) {
            @Override
            public void onTick(long l) {
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
                Random ran = new Random();
                int x = ran.nextInt(5) + 1;

                Log.i(String.valueOf(x), "num");

                switch (x) {
                    case 1:
                        lp.gravity = Gravity.TOP | Gravity.LEFT;
                        break;
                    case 2:
                        lp.gravity = Gravity.TOP | Gravity.RIGHT;
                        break;
                    case 3:
                        lp.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                        break;
                    case 4:
                        lp.gravity = Gravity.BOTTOM | Gravity.LEFT;
                        break;
                    case 5:
                        lp.gravity = Gravity.CENTER;
                        break;
                }

                btn1.setLayoutParams(lp);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "se termino", Toast.LENGTH_SHORT).show();
                d.setText("juego terminado");
            }
        }.start();

        /*Button f= findViewById(R.id.miboton);
        f.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"nachos",Toast.LENGTH_LONG).show();
            }
        });*/
        //esto es una nota
    }
}
