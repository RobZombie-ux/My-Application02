package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditText1;
    private TextInputEditText textInputEditText2;
    private TextInputEditText textInputEditText3;
    private TextInputEditText textInputEditText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditText1 = (TextInputEditText)findViewById(R.id.txtNombre);
        textInputEditText2 = (TextInputEditText)findViewById(R.id.txtSandalias);
        textInputEditText3 = (TextInputEditText)findViewById(R.id.txtTenis);
        textInputEditText4 = (TextInputEditText)findViewById(R.id.txtMocasines);

    }

    public void Calcular(View view){
        String Nombre = textInputEditText1.getText().toString();
        String sSandalias = textInputEditText2.getText().toString();
        int Sandalias = Integer.parseInt(sSandalias);
        String sTenis = textInputEditText3.getText().toString();
        int Tenis = Integer.parseInt(sTenis);
        String sMocasines = textInputEditText4.getText().toString();
        int Mocasines = Integer.parseInt(sMocasines);

        //Precio de Sandalias = 20 --> Ganancia del 55%= 11 :: 20+11=31
        //Precio de Tenis = 60 --> Ganancia del 55%= 33 :: 60+33=93
        //Precio de Mocasines = 40 --> Ganancia del 55%= 22 :: 40+22=62
        int subTotal = Sandalias*31 + Tenis*93 + Mocasines*62;
        double descuento = subTotal*0.08;
        double TotalConDescuento = subTotal - descuento;
        double Total = TotalConDescuento + (TotalConDescuento*0.18);

        //Vincular actividades
        Intent i = new Intent(this, MainActivity2.class);
        //Definir parámetros
        i.putExtra("dato1",Nombre);
        i.putExtra("dato2",subTotal);
        i.putExtra("dato3",descuento);
        i.putExtra("dato4",TotalConDescuento);
        i.putExtra("dato5",Total);

        startActivity(i);

    }
}