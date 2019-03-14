package br.senai.sp.agenda.agenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.senai.sp.agenda.DAO.ContatoDAO;
import br.senai.sp.agenda.R;
import br.senai.sp.agenda.modelo.Contato;




public class CadastroActivity extends AppCompatActivity {



    private CadastroContatoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        helper = new CadastroContatoHelper(CadastroActivity.this);

        Intent intent = getIntent();

        final Contato contato = (Contato) intent.getSerializableExtra("contato");

        if(contato!=null){
            helper.preencherFormulario(contato);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_botoao_salvar,menu);
        inflater.inflate(R.menu.menu_botao_deletar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        switch(item.getItemId()){
            case R.id.menu_salvar:
                Contato contatoSalvar = helper.getContato();
                ContatoDAO daoSalvar = new ContatoDAO(CadastroActivity.this);
            if(helper.validar(this)==true) {


                if (contatoSalvar.getId() != 0) {
                    daoSalvar.atualizar(contatoSalvar);
                    Toast.makeText(CadastroActivity.this, "contato atualizado com sucesso", Toast.LENGTH_LONG).show();


                } else {
                    daoSalvar.salvar(contatoSalvar);
                    Toast.makeText(CadastroActivity.this, "contato salvo com sucesso", Toast.LENGTH_LONG).show();

                }


                daoSalvar.close();
                finish();
            }
                break;

            case R.id.menu_deletar:
                final Contato contatoDeletar = helper.getContato();


                if(contatoDeletar.getId() == 0 ){
                    Toast.makeText(CadastroActivity.this,"Contato ainda nao cadastrado",Toast.LENGTH_LONG).show();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroActivity.this);
                    builder.setTitle("Deletando contato");
                    builder.setMessage("Tem certeza que deseja excluir o  contato  " + contatoDeletar.getNome() + "?");
                    builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                             ContatoDAO daoExcluir = new ContatoDAO(CadastroActivity.this);

                                daoExcluir.excluir(contatoDeletar);
                                daoExcluir.close();
                                Toast.makeText(CadastroActivity.this,"Contato deletado",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(CadastroActivity.this,MainActivity.class);
                                startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("não",null);
                    builder.create().show();

                }


                default:
        }

        return super.onOptionsItemSelected(item);
    }

}
