package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity {

    private TextView tvNombre, tvNac, tvTelefono, tvCorreo, tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);


        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("Nombre");
        String fechaNac = parametros.getString("Fecha");
        String telefono = parametros.getString("Tel");
        String correo = parametros.getString("Correo");
        String descripcion = parametros.getString("Desc");


        tvNombre = (TextView) findViewById(R.id.PutNombre);
        tvNombre.setText(nombre);

        tvNac = (TextView) findViewById(R.id.PutFecha);
        tvNac.setText(tvNac.getText() + fechaNac);

        tvTelefono = (TextView) findViewById(R.id.PutTel);
        tvTelefono.setText(telefono);

        tvCorreo = (TextView) findViewById(R.id.PutEmail);
        tvCorreo.setText(correo);

        tvDescripcion = (TextView) findViewById(R.id.PutDescripcion);
        tvDescripcion.setText(descripcion);

        Button BotonEditar = (Button) findViewById(R.id.BotonEditar);

        BotonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}