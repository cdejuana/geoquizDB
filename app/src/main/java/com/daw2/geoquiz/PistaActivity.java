package com.daw2.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class PistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista);

        int pista = getIntent().getIntExtra("PISTA", 0);

        Toast.makeText(PistaActivity.this, getString(pista), Toast.LENGTH_SHORT).show();
    }
}
