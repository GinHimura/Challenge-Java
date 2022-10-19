package br.com.candidate.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Usuario {

    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected LocalDate dataCriacao = LocalDate.now();
    protected String telefone;

    public Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setId();
    }

    public boolean login(String email, String senha) {
        if (!email.equals(getEmail()) || !senha.equals(getSenha())) {
            System.out.println("Login inválido. Tente novamente");
            return false;
        }
        return true;
    }

    ;

    public int getId() {
        return this.id;
    }

    private void setId() {
        SecureRandom rng = new SecureRandom();
        int rgnInt = rng.nextInt();
        this.id = rgnInt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

}
