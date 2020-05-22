package br.ifsc.edu.myblocodenotassqlite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textoNota;
    TextView Resultado;
    NotaController notaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notaController = new NotaController(MainActivity.this);

        textoNota = findViewById(R.id.nota);
        Resultado = findViewById(R.id.texto);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textoNota.equals("")){
                    Nota nota = new Nota(1,textoNota.getText().toString());
                    if(notaController.VeSeIdExiste(1)){
                        notaController.updateNota(nota);
                        Resultado.setText(notaController.recuperaNota());
                    }else{
                        notaController.salvarNota(nota);
                        Resultado.setText(notaController.recuperaNota());
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Não é possivel criar a nota!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Resultado.setText(notaController.recuperaNota());
    }

    @Override
    protected void onPause() {
        super.onPause();

        Nota nota = new Nota(1,textoNota.getText().toString());

        if(notaController.VeSeIdExiste(1)){
            notaController.updateNota(nota);
        }else{
            notaController.salvarNota(nota);
        }
    }
}
