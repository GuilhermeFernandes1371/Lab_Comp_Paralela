package model.bean;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private int id;

    public Cliente(int id, String nome, String telefone, String email, String senha){
       this.setId(id);
       this.setNome(nome);
       this.setEmail(email);
       this.setTelefone(telefone);
       this.setSenha(String.valueOf(senha));
    }
    public Cliente(){
        this.setNome(null);
        this.setEmail(null);
        this.setTelefone(null);
        this.setSenha(null);
        this.setId(0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
