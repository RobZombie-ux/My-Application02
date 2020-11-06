package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recibeDatos();

    }

    public void recibeDatos(){
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("dato1");
        int subtotal = extras.getInt("dato2");
        double descuento = extras.getDouble("dato3");
        double totalConDescuento = extras.getDouble("dato4");
        double total = extras.getDouble("dato5");

        //
        textView1 = (TextView)findViewById(R.id.txtResultado1);
        textView2 = (TextView)findViewById(R.id.txtResultado2);
        textView3 = (TextView)findViewById(R.id.txtResultado3);
        textView4 = (TextView)findViewById(R.id.txtResultado4);

        //Especificar el número de cifras..
        DecimalFormat df = new DecimalFormat("#.00");

        textView1.setText("Hola "+name+" el valor de la venta sin descuento es S/."+subtotal);
        textView2.setText("El descuento es S/."+descuento);
        textView3.setText("El valor de la venta con descuento es S/."+df.format(totalConDescuento));
        textView4.setText("Valor de la venta incluyendo IGV es S/."+df.format(total));

    }

}