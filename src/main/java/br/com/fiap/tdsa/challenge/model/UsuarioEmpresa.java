package br.com.fiap.tdsa.challenge.model;

import java.util.ArrayList;

public class UsuarioEmpresa extends Usuario {
    private ArrayList<Feedback> feedbacks = new ArrayList<>();
    private ArrayList<Vaga> vagas = new ArrayList<>();
    private String website;

    public UsuarioEmpresa(String nome, String email, String senha, String website) {
        super(nome, email, senha);
        setWebsite(website);
    }

    public Vaga criarVaga(String nomeVaga, String descricaoVaga, boolean exclusivoEstudante,
                          ArrayList<Competencia> competencias, ArrayList<Idioma> idiomas, String cargo, String area, String dataTermino, char presencial) {
        Vaga vaga = new Vaga(nomeVaga, descricaoVaga, exclusivoEstudante, competencias, idiomas, this, cargo, area, dataTermino, presencial);
        ArrayList<Vaga> vagasAtuais = getVagas();
        vagasAtuais.add(vaga);
        setVagas(vagasAtuais);
        return vaga;
    }

    public boolean removerVaga(Vaga vagaRemover) {
        ArrayList<Vaga> vagas = getVagas();

        if (vagas.contains(vagaRemover)) {
            vagas.remove(vagaRemover);
            setVagas(vagas);
            return true;
        }

        return false;
    }

    public Feedback criarFeedback(String motivoFeedback, UsuarioCandidato candidato, int qtdRequisitosAtendidos, char aprovado) {
        Feedback feedback = new Feedback(motivoFeedback, candidato, this, qtdRequisitosAtendidos, aprovado);
        ArrayList<Feedback> candidatoFeedbacks = candidato.getFeedbacks();
        candidatoFeedbacks.add(feedback);
        candidato.setFeedbacks(candidatoFeedbacks);
        ArrayList<Feedback> feedbacksAtuais = getFeedbacks();
        feedbacksAtuais.add(feedback);
        setFeedbacks(feedbacksAtuais);
        return feedback;
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

    public boolean solicitarCriacaoCompetencia(String softSkill, String hardSkill) {
        /*
         * Simula envio e aprovação da criação de competencias pelos adms do site.
         * Retorna true pois foi aprovado e criado a competencia solicitada e que será
         * salva no BD
         */
        new Competencia(softSkill, hardSkill);
        return true;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;

    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    private void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    private void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        String resumo = "Nome: " + getNome() + "\nEmail: " + getEmail() + "\nWebsite: " + getWebsite()
                + "\nData de criação: " + getDataCriacao()
                + "\nTelefones: " + getTelefone()
                + "\nVagas: ";

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
