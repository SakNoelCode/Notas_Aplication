package com.example.aplicationnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Nota1,Nota2,Nota3,Nota4;
    private TextView tvPromedio,tvMayor,tvMenor;
    private int nota1,nota2,nota3,nota4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nota1 = findViewById(R.id.txtNota1);
        Nota2 = findViewById(R.id.txtNota2);
        Nota3 = findViewById(R.id.txtNota3);
        Nota4 = findViewById(R.id.txtNota4);

        tvPromedio = findViewById(R.id.tvPromedio);
        tvMayor = findViewById(R.id.tvMayor);
        tvMenor = findViewById(R.id.tvMenor);

    }


    private void obtenerValores(){
        nota1 = Integer.parseInt(Nota1.getText().toString());
        nota2 = Integer.parseInt(Nota2.getText().toString());
        nota3 = Integer.parseInt(Nota3.getText().toString());
        nota4 = Integer.parseInt(Nota4.getText().toString());
    }

    private boolean esValido(int val){
        if(val >=0 && val<=20){
            return true;
        }else{
            return false;
        }
    }


    public void Promediar(View view){
        obtenerValores();
        if(esValido(nota1) && esValido(nota2) && esValido(nota3) && esValido(nota4)){
            double prom = (double) (nota1+nota2+nota3+nota4)/4;

            if(prom>12){
                tvPromedio.setText("Aprobado con "+ prom);
                Toast.makeText(this,"Felicitaciones",Toast.LENGTH_SHORT).show();
            }else{
                tvPromedio.setText("Reprobado con "+ prom);
                Toast.makeText(this,"Siga estudiando",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Entradas incorrectas",Toast.LENGTH_SHORT).show();
        }
    }


    public void Mayor(View view){
        obtenerValores();
        if(esValido(nota1) && esValido(nota2) && esValido(nota3) && esValido(nota4)){
            int lista[] = {nota1,nota2,nota3,nota4};
            int may = nota1;
            for (int i = 0;i <lista.length;i++){
                if(lista[i]>may){
                    may = lista[i];
                }
            }
            tvMayor.setText(String.valueOf(may));
        }else{
            Toast.makeText(this,"Entradas incorrectas",Toast.LENGTH_SHORT).show();
        }
    }

    public void Menor(View view){
        obtenerValores();
        if(esValido(nota1) && esValido(nota2) && esValido(nota3) && esValido(nota4)){
            int lista[] = {nota1,nota2,nota3,nota4};
            int menor = nota1;
            for (int i = 0;i <lista.length;i++){
                if(lista[i] < menor){
                    menor = lista[i];
                }
            }
            tvMenor.setText(String.valueOf( menor));
        }else{
            Toast.makeText(this,"Entradas incorrectas",Toast.LENGTH_SHORT).show();
        }
    }


}