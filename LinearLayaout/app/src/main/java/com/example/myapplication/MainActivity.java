package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("hola gerger");
        Log.i("mensaje", "hola mundo");
        // Declarar variables
        int numEntero = 10;
        float numFlotante = 3.14f;
        char caracter = 'A';
        boolean valorBooleano = true;

        // Imprimir valores de las variables
        System.out.println("Valor del entero: " + numEntero);
        System.out.println("Valor del flotante: " + numFlotante);
        System.out.println("Valor del caracter: " + caracter);
        System.out.println("Valor del booleano: " + valorBooleano);

        // Realizar operaciones con las variables
        int suma = numEntero + 5;
        float multiplicacion = numFlotante * 2;
        char siguienteCaracter = (char)(caracter + 1);
        boolean negacion = !valorBooleano;

        // Imprimir resultados de las operaciones
        System.out.println("Suma del entero: " + suma);
        System.out.println("Multiplicación del flotante: " + multiplicacion);
        System.out.println("Siguiente caracter: " + siguienteCaracter);
        System.out.println("Negación del booleano: " + negacion);
        calcularCuadrado(numEntero);
        int cuadrado = 0;
        System.out.println("cuadrado global: " + cuadrado);
    }

    public void calcularCuadrado(int numero){
        int cuadrado = numero*numero;
        System.out.println("cuadrado dentro del metodo: " + cuadrado);
    }
}