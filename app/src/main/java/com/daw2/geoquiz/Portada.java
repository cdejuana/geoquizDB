package com.daw2.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Portada extends AppCompatActivity {

    private Button bt_app;
    private Button bt_cargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        bt_app = findViewById(R.id.bt_acceder_app);
        bt_cargar = findViewById(R.id.bt_valores_x_defecto);

        bt_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
            }
        });

        bt_cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreguntasDB preguntasBD = new PreguntasDB(getApplicationContext());
                ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
                //estos datos se bajarían de un servidor
                Pregunta pregunta1 = new Pregunta(1, "madrid",
                        "¿Cual es la ciudad de la imagen?",
                        "Madrid",
                        "Londres",
                        "París",
                        1,
                        "Es la capital de españa");
                Pregunta pregunta2 = new Pregunta(2, "tamesis",
                        "¿Cual es el río de la imagen?",
                        "manzanares",
                        "sena",
                        "tamesis",
                        3,
                        "XXXX");
                Pregunta pregunta3 = new Pregunta(3, "tamesis",
                        "¿cual es la montaña de la imagen",
                        "Teide",
                        "Everest",
                        "Kilimanjaro",
                        3,
                        "XXX");
                listaPreguntas.add(pregunta1);
                listaPreguntas.add(pregunta2);
                listaPreguntas.add(pregunta3);

                preguntasBD.instertarListaPreguntas(listaPreguntas);
            }
        });
    }
}
