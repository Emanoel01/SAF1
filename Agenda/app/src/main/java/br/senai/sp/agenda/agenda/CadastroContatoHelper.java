package br.senai.sp.agenda.agenda;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import br.senai.sp.agenda.R;
import br.senai.sp.agenda.modelo.Contato;

public class CadastroContatoHelper {

    private EditText txtNome;
    private EditText txtEndereco;
    private EditText txtTelefone;
    private EditText txtEmail;
    private EditText txtEnderecoLinkedin;
    private Contato contato;

    private TextInputLayout layoutNome,
            layoutEndereco,
            layoutTelefone,
            layoutEmail,
            layoutEnderecoLinkedin;

    public  CadastroContatoHelper (CadastroActivity activity){
        txtNome = activity.findViewById(R.id.txt_nome);
        txtEndereco = activity.findViewById(R.id.txt_endereco);
        txtTelefone = activity.findViewById(R.id.txt_telefone);
        txtEmail = activity.findViewById(R.id.txt_email);
        txtEnderecoLinkedin = activity.findViewById(R.id.txt_linkedin);

        layoutNome = activity.findViewById(R.id.layout_txt_nome);
        layoutEndereco = activity.findViewById(R.id.layout_txt_endereco);
        layoutTelefone = activity.findViewById(R.id.layout_txt_telefone);
        layoutEmail = activity.findViewById(R.id.layout_txt_email);
        layoutEnderecoLinkedin = activity.findViewById(R.id.layout_txt_endereco_linkedin);


        contato = new Contato();
    }

    public Contato getContato(){
        contato.setNome(txtNome.getText().toString());
        contato.setEndereco(txtEndereco.getText().toString());
        contato.setTelefone(txtTelefone.getText().toString());
        contato.setEmail(txtEmail.getText().toString());
        contato.setEnderecoLinkdin(txtEnderecoLinkedin.getText().toString());
        return contato;
    }

    public void preencherFormulario(Contato contato){
        txtNome.setText(contato.getNome());
        txtEndereco.setText(contato.getEndereco());
        txtEmail.setText(contato.getEmail());
        txtEnderecoLinkedin.setText(contato.getEnderecoLinkdin());
        txtTelefone.setText(contato.getTelefone());
        this.contato = contato;
    }

    public boolean validar(Context activity) {
        boolean validado = true;

        if (txtNome.getText().toString().isEmpty()) {

            layoutNome.setErrorEnabled(true);
            layoutNome.setError("Digite o nome");
            validado = false;

        } else {
            layoutNome.setErrorEnabled(false);
        }

        if(txtEndereco.getText().toString().isEmpty()){
            layoutEndereco.setErrorEnabled(true);
            layoutEndereco.setError("Digite o endereço");
            validado = false;
        }else{
            layoutEndereco.setErrorEnabled(false);
        }

        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError("Digite o Email");
            validado = false;
        }else{
            layoutEmail.setErrorEnabled(false);
        }

        if(txtTelefone.getText().toString().isEmpty()){
            layoutTelefone.setErrorEnabled(true);
            layoutTelefone.setError("Digite o telefone");
            validado = false;
        }else{
            layoutTelefone.setErrorEnabled(false);
        }

        if(txtEnderecoLinkedin.getText().toString().isEmpty()){
            layoutEnderecoLinkedin.setErrorEnabled(true);
            layoutEnderecoLinkedin.setError("Digite o endereço linkedin");
            validado = false;
        }else{
            layoutEnderecoLinkedin.setErrorEnabled(false);
        }



        return validado;
        }



    }

