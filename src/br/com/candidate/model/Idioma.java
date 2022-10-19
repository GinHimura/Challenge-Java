package br.com.candidate.model;

import java.security.SecureRandom;
import java.util.Objects;

public class Idioma {
    private int id;
    private String nome;
    private String nivelProeficiencia;

    public Idioma(String nome, String nivelProeficiencia) {
        setNome(nome);
        setNivelProeficiencia(nivelProeficiencia);
        setId();
    }

    public int getId() {
        return id;
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

    public String getNivelProeficiencia() {
        return nivelProeficiencia;
    }

    public void setNivelProeficiencia(String nivelProeficiencia) {
        this.nivelProeficiencia = nivelProeficiencia;
    }

    @Override
    public String toString() {
        return "Idioma: " + getNome() + "\nNível de proeficiência: " + getNivelProeficiencia();
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
        Idioma other = (Idioma) obj;
        return Objects.equals(id, other.id);
    }

}
