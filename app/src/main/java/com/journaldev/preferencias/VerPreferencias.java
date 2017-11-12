package com.journaldev.preferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.journaldev.preferencias.R.id.mensaje;

public class VerPreferencias extends AppCompatActivity {

    private TextView message;
    private String nombre;
    private String fecha;
    private String dni;
    private boolean hombre;
    private boolean mujer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_preferencias);

        //Identificar componentes
        message = (TextView) findViewById(mensaje);

        //Recuperar preferencias guardadas
        recuperaPref();

        //Componer mensaje
        String mensaje = componerMensaje();

        //Mostrar mensaje
        message.setText(mensaje);

    }

    private void recuperaPref() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        nombre = sharedPref.getString("nombre", "-------");
        fecha = sharedPref.getString("fecha", "-------");
        dni = sharedPref.getString("dni", "-------");
        hombre = sharedPref.getBoolean("hombre", false);
        mujer = sharedPref.getBoolean("mujer", false);

    }

    private String componerMensaje() {
        String mensaje = "Hola " + nombre + " tu DNI es " + dni + " y la fecha introducida es " +
                fecha + " y eres ";

        if (hombre) {
            mensaje += "hombre";
        } else {
            mensaje += "mujer";
        }

        return mensaje;

    }
}
