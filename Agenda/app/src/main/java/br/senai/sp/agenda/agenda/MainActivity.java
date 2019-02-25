package br.senai.sp.agenda.agenda;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import br.senai.sp.agenda.R;

public class MainActivity extends AppCompatActivity {

    private Button btnAdicionar;
    private ListView lista_contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onEnterAnimationComplete();

        String[] contatos = {"Contato1","Contato2","Contato3","Contato4"};

        lista_contatos = findViewById(R.id.list_contatos);

        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirCadastro = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(abrirCadastro);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        ArrayAdapter<String> listaContatosAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contatos);

        lista_contatos.setAdapter(listaContatosAdapter);

        //ArrayAdapter<> Contatos = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contatos);

    }




}
