package com.journaldev.preferencias;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText data;
    private EditText dni;
    private RadioButton mascle;
    private RadioButton femella;
    private Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se identifican los componentes
        nom = (EditText) findViewById(R.id.nombre);
        data = (EditText) findViewById(R.id.fecha);
        dni = (EditText) findViewById(R.id.dni);
        mascle = (RadioButton) findViewById(R.id.hombre);
        femella = (RadioButton) findViewById(R.id.mujer);
        enviar = (Button) findViewById(R.id.enviar);

        //Hacer que el boton funcione
        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Guardamos las preferencias
                guardarPref();

                //Cambiar activity
                cambioActivity();
            }

        });
    }

    private void guardarPref() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nombre", nom.getText().toString());
        editor.putString("fecha", data.getText().toString());
        editor.putString("dni", dni.getText().toString());
        editor.putBoolean("hombre", mascle.isChecked());
        editor.putBoolean("mujer", femella.isChecked());
        editor.commit();

    }

    private void cambioActivity() {
        Intent intent = new Intent(this, VerPreferencias.class);
        startActivity(intent);
    }

}
