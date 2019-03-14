package br.senai.sp.agenda.agenda;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import br.senai.sp.agenda.DAO.ContatoDAO;
import br.senai.sp.agenda.R;
import br.senai.sp.agenda.modelo.Contato;

public class MainActivity extends AppCompatActivity {

    private Button btnAdicionar;
    private ListView lista_contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onEnterAnimationComplete();

        lista_contatos = findViewById(R.id.list_contatos);
        carregarContatos();

        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirCadastro = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(abrirCadastro);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });



        lista_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato = (Contato) lista_contatos.getItemAtPosition(position);


                Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
                intent.putExtra("contato", contato);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out);


            }
        });

        registerForContextMenu(lista_contatos);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_botao_deletar,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Contato contato = (Contato) lista_contatos.getItemAtPosition(info.position);



        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Deletando Contato");
        builder.setMessage("Tem certeza que deseja deletar " + contato.getNome());
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               ContatoDAO dao = new ContatoDAO(MainActivity.this);

               dao.excluir(contato);
               dao.close();
               carregarContatos();

            }
        });
        builder.setNegativeButton("não",null);
        builder.create().show();




        return super.onContextItemSelected(item);
    }

    public void carregarContatos(){
        ContatoDAO dao = new ContatoDAO(MainActivity.this);
        List<Contato> listContato = dao.getContatos();
        dao.close();

        ArrayAdapter<Contato> arrayContato = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,listContato);

        lista_contatos.setAdapter(arrayContato);


    }


    @Override
    protected void onResume() {
        super.onResume();
        carregarContatos();

    }




}
