package com.daw2.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_textoPregunta;
    private Button bt_opcionA;
    private Button bt_opcionB;
    private Button bt_opcionC;
    private Button bt_siguiente;
    private Button bt_ayuda;
    private Button bt_pista;
    private ImageView iv_imagen;
    private int indice;
    private ArrayList <Pregunta> listaPreguntas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_textoPregunta = findViewById(R.id.tv_pregunta);
        bt_opcionA = findViewById(R.id.bt_A);
        bt_opcionB = findViewById(R.id.bt_B);
        bt_opcionC = findViewById(R.id.bt_C);
        bt_siguiente = findViewById(R.id.bt_siguiente);
        iv_imagen = findViewById(R.id.iv_ciudad1);
        bt_ayuda = findViewById(R.id.bt_ayuda);
        bt_pista = findViewById(R.id.bt_pista);
        indice = 0;

        //SharedPreferences

        bt_opcionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaPreguntas.get(indice).getResultado() == 1){
                    Toast.makeText(MainActivity.this, R.string.acierto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.fallo, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_opcionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaPreguntas.get(indice).getResultado() == 3){
                    Toast.makeText(MainActivity.this, R.string.acierto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.fallo, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_opcionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaPreguntas.get(indice).getResultado() == 2){
                    Toast.makeText(MainActivity.this, R.string.acierto, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.fallo, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice < (listaPreguntas.size()-1)){
                    indice ++;
                    cambiarPregunta();
                } else {
                    Toast.makeText(MainActivity.this, R.string.ultima_pregunta, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(i);
            }
        });

        bt_pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PistaActivity.class);
                i.putExtra("PISTA", listaPreguntas.get(indice).getPista());
                startActivity(i);
            }
        });
    }

    private void cambiarPregunta() {
        tv_textoPregunta.setText(listaPreguntas.get(indice).getTexto_pregunta());
        iv_imagen.setImageResource(getResources().getIdentifier(
                listaPreguntas.get(indice).getImagen(), "drawable", getPackageName()));
        bt_opcionA.setText(listaPreguntas.get(indice).getOpcion1());
        bt_opcionB.setText(listaPreguntas.get(indice).getOpcion2());
        bt_opcionC.setText(listaPreguntas.get(indice).getOpcion3());
    }
}