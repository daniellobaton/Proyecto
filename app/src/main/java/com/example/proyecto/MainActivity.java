package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String nombre, telefono, correo, descripcion;
    private TextView fecha;
    String date;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha = findViewById(R.id.Fecha);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;

                date = day + "/" + month + "/" + year;

                fecha.setText(date);
            }
        };


        Button BotonSiguiente = (Button) findViewById(R.id.BotonSiguiente);

        BotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConfirmaDatos.class);

                TextInputEditText tinombre = findViewById(R.id.Nombretexto);
                TextInputEditText titelefono = findViewById(R.id.Telefonotexto);
                TextInputEditText ticorreo = findViewById(R.id.Correotexto);
                TextInputEditText tidescripcion = findViewById(R.id.Descripciontexto);

                nombre = tinombre.getText().toString();
                telefono = titelefono.getText().toString();
                correo = ticorreo.getText().toString();
                descripcion = tidescripcion.getText().toString();

                intent.putExtra("Nombre", nombre);
                intent.putExtra("Fecha", date);
                intent.putExtra("Tel", "Tel: " + telefono);
                intent.putExtra("Correo", "Correo: " + correo);
                intent.putExtra("Desc", "Descripción: " + descripcion);

                startActivity(intent);

            }
        });
    }

}