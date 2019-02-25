package br.senai.sp.agenda.modelo;

public class Contato {


    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String enderecoLinkdin;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoLinkdin() {
        return enderecoLinkdin;
    }

    public void setEnderecoLinkdin(String enderecoLinkdin) {
        this.enderecoLinkdin = enderecoLinkdin;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
