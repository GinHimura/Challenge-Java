package br.com.fiap.tdsa.challenge.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UsuarioCandidato extends Usuario {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ArrayList<Feedback> feedbacks = new ArrayList<>();
    private ArrayList<Vaga> vagas = new ArrayList<>();
    private ArrayList<Competencia> competencias = new ArrayList<>();
    private ArrayList<Idioma> idiomas = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Formacao> formacoes = new ArrayList<>();
    private ArrayList<Certificado> certificados = new ArrayList<>();
    private char estudante = 'n';
    private String dataNascimento;
    private LocalDate dt_dataNascimento = LocalDate.now();
    private char genero = 'f';

    public UsuarioCandidato(String nome, String email, String senha, String dataNascimento, char genero) {
        super(nome, email, senha);
        setDataNascimento(dataNascimento);
        setGenero(genero);
    }

    public boolean candidatar(Vaga vagaCandidatar) {
        ArrayList<Vaga> vagas = getVagas();

        if (vagas.contains(vagaCandidatar)) {
            return false;
        }

        vagas.add(vagaCandidatar);
        setVagas(vagas);
        return true;
    }

    public boolean removerCandidatura(Vaga vagaRemover) {
        ArrayList<Vaga> vagas = getVagas();

        if (vagas.contains(vagaRemover)) {
            vagas.remove(vagas.indexOf(vagaRemover));
            setVagas(vagas);
            return true;
        }

        return false;
    }

    public boolean removerFeedback(Feedback feedbackRemover) {
        ArrayList<Feedback> feedbacks = getFeedbacks();

        if (feedbacks.contains(feedbackRemover)) {
            feedbacks.remove(feedbackRemover);
            setFeedbacks(feedbacks);
            return true;
        }

        return false;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.dt_dataNascimento = LocalDate.parse(dataNascimento, formatoData);
    }

    public LocalDate getDt_DataNascimento() {
        return dt_dataNascimento;
    }

    public String getGenero() {
        return genero == 'm' ? "Masculino" : "Feminino";
    }

    public void setGenero(char genero) {
        genero = Character.toLowerCase(genero);
        if (genero == 'm') {
            this.genero = genero;
        } else {
            this.genero = 'f';
        }
    }

    public char getGeneroRaw() {
        return genero;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    private void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }

    public ArrayList<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(ArrayList<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }

    public boolean isEstudante() {
        return Character.toLowerCase(estudante) == 's';
    }

    public char getEstudante() {
        return estudante;
    }

    public void setEstudante(char estudante) {
        this.estudante = estudante;
    }

    @Override
    public String toString() {
        String resumo = "Nome: " + getNome() + "\nEmail: " + getEmail() + "\nData de criação: " + getDataCriacao()
                + "\nTelefone: " + getTelefone() + "\nÉ estudante? " + (isEstudante() == true ? "Sim" : "Não")
                + "\nGênero: " + getGenero() + "\nData de Nascimento: " + getDataNascimento()
                + "\nCompetencias: ";

        for (Competencia competencia : getCompetencias()) {
            resumo += "\n\t" + competencia.getSoftSkill() + "\n\t" + competencia.getHardSkill();
        }

        resumo += "\nIdiomas: ";
        for (Idioma idioma : getIdiomas()) {
            resumo += "\n\t" + idioma.getNome() + " - " + idioma.getNivelProeficiencia();
        }

        resumo += "\nExperiências: ";
        for (Curso exp : getCursos()) {
            resumo += "\n\t" + exp.getNome();
        }

        resumo += "\nFormações: ";
        for (Formacao formacao : getFormacoes()) {
            resumo += "\n\t" + formacao.getNomeInstituicao();
        }

        resumo += "\nCertificados: ";
        for (Certificado certificado : getCertificados()) {
            resumo += "\n\t" + certificado.getNome();
        }

        resumo += "\nVagas:";
        for (Vaga vaga : getVagas()) {
            resumo += "\n\t" + vaga.getNome();
        }

        resumo += "\nFeedbacks: ";
        for (Feedback feedback : getFeedbacks()) {
            resumo += "\n\t" + feedback.getEmpresa().getNome() + " - " + feedback.getAprovado();
        }

        return resumo;
    }

}
