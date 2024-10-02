package com.jaimito.estudiarinformatica;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spCiclo, spPoblacion, spTipo;
    Button btnBorrar;
    TextView tvInfo;

    String ciclo = "", poblacion = "", tipo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);
        spCiclo = findViewById(R.id.spCiclo);
        spPoblacion = findViewById(R.id.spPoblacion);
        spTipo = findViewById(R.id.spTipo);
        btnBorrar = findViewById(R.id.btnBorrar);

        btnBorrar.setOnClickListener(view -> borrar());

        ArrayAdapter<CharSequence> adapterCiclo = ArrayAdapter.createFromResource(this, R.array.spCiclo, android.R.layout.simple_spinner_item);
        adapterCiclo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiclo.setAdapter(adapterCiclo);
        spCiclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciclo = spCiclo.getSelectedItem().toString();
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ciclo = "";
            }
        });

        ArrayAdapter<CharSequence> adapterPoblacion = ArrayAdapter.createFromResource(this, R.array.spPoblacion, android.R.layout.simple_spinner_item);
        adapterPoblacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPoblacion.setAdapter(adapterPoblacion);
        spPoblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                poblacion = spPoblacion.getSelectedItem().toString();
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                poblacion = "";
            }
        });

        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this, R.array.spTipo, android.R.layout.simple_spinner_item);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapterTipo);
        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo = spTipo.getSelectedItem().toString();
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tipo = "";
            }
        });
    }

    private void mostrarInfo() {
        if (!ciclo.isEmpty() && !poblacion.isEmpty() && !tipo.isEmpty()) {
            tvInfo.setText(ciclo + " en " + poblacion + " de forma " + tipo);
        } else {
            tvInfo.setText("");
        }
    }

    private void borrar() {
        spCiclo.setSelection(0);
        spPoblacion.setSelection(0);
        spTipo.setSelection(0);
    }
}
