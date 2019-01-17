package com.example.rey_m.tercerintento;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    int cont=0;
    TextView t;
    TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.miboton);

        btn1=findViewById(R.id.btn1);
        t=findViewById(R.id.texcont);
        t.setText("Clicks");
        d=findViewById(R.id.texdone);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                t.setText("clicks: "+String.valueOf(cont));
            }
        });

        new CountDownTimer(10000, 500) {
            @Override
            public void onTick(long l) {

                FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(-2,-2);
                /*lp.gravity=Gravity.TOP;
                btn1.setLayoutParams(lp);*/
                Random r=new Random();
                int n = r.nextInt(5) + 1;
                switch (n){
                    case 1:lp.gravity=Gravity.TOP|Gravity.LEFT;
                        break;
                    case 2:lp.gravity=Gravity.TOP|Gravity.RIGHT;
                    break;
                    case 3:lp.gravity=Gravity.BOTTOM|Gravity.RIGHT;
                    break;
                    case 4:lp.gravity=Gravity.BOTTOM|Gravity.LEFT;
                    break;
                    case 5:lp.gravity=Gravity.CENTER;
                    break;
                }
                btn1.setLayoutParams(lp);
            }

            @Override
            public void onFinish() {
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
