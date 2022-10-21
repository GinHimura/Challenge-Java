package br.com.fiap.tdsa.challenge.model;

import java.security.SecureRandom;
import java.util.Objects;

public class Feedback {
    private int id;
    private String sugestoes;
    private int qtdRequisitosAtendidos = 0;
    private char aprovado = 'n';
    private UsuarioCandidato candidato;
    private UsuarioEmpresa empresa;

    public Feedback(String sugestoes, UsuarioCandidato candidato, UsuarioEmpresa empresa, int qtdRequisitosAtendidos, char aprovado) {
        setSugestoes(sugestoes);
        setCandidato(candidato);
        setEmpresa(empresa);
        setAprovado(aprovado);
        setQtdRequisitosAtendidos(qtdRequisitosAtendidos);
        setId();
    }

    public void notificarCandidato(UsuarioCandidato candidato) {
        System.out.println("Enviando notificação para " + candidato.getNome() + ".");
        // Simula notificação para o Candidato quando receber um feedback
    }

    public int getId() {
        return id;
    }

    private void setId() {
        SecureRandom rng = new SecureRandom();
        int rgnLong = rng.nextInt();
        this.id = rgnLong;
    }

    public int getQtdRequisitosAtendidos() {
        return qtdRequisitosAtendidos;
    }

    public void setQtdRequisitosAtendidos(int qtdRequisitosAtendidos) {
        this.qtdRequisitosAtendidos = qtdRequisitosAtendidos;
    }

    public String getAprovado() {
        return aprovado == 'n' ? "Reprovado" : "Aprovado";
    }

    public void setAprovado(char aprovado) {
        aprovado = Character.toLowerCase(aprovado);
        if (aprovado == 's') {
            this.aprovado = aprovado;
        } else {
            this.aprovado = 'n';
        }
    }

    public char getAprovadoRaw() {
        return aprovado;
    }

    public String getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(String sugestoes) {
        this.sugestoes = sugestoes;
    }

    public UsuarioCandidato getCandidato() {
        return candidato;
    }

    private void setCandidato(UsuarioCandidato candidato) {
        this.candidato = candidato;
    }

    public UsuarioEmpresa getEmpresa() {
        return empresa;
    }

    private void setEmpresa(UsuarioEmpresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empresa responsável pelo feedback: " + getEmpresa().getNome() + "\nSugestões: " + getSugestoes()
                + "\nSituação: " + getAprovado()
                + "\nQuantidade de requisitos atendidos: " + getQtdRequisitosAtendidos()
                + "\nCandidato alvo do feedback: " + getCandidato().getNome();
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
        Feedback other = (Feedback) obj;
        return Objects.equals(id, other.id);
    }

}
