package br.com.candidate.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Vaga {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao = LocalDate.now();
    private String dataTermino;
    private LocalDate dt_dataTermino = LocalDate.now();
    private char presencial = 's';
    private String cargo;
    private String area;
    private boolean exclusivoEstudante = false;
    private ArrayList<Competencia> competencias = new ArrayList<>();
    private ArrayList<Idioma> idiomas = new ArrayList<>();
    private UsuarioEmpresa empresa;

    public Vaga(String nome, String descricao, UsuarioEmpresa empresa, String cargo, String area, String dataTermino, char presencial) {
        setNome(nome);
        setDescricao(descricao);
        setEmpresa(empresa);
        setId();
        setCargo(cargo);
        setArea(area);
        setDataTermino(dataTermino);
        setPresencial(presencial);
    }

    public Vaga(String nome, String descricao, boolean exclusivoEstudante, ArrayList<Competencia> competencias,
                ArrayList<Idioma> idiomas, UsuarioEmpresa empresa, String cargo, String area, String dataTermino, char presencial) {
        setNome(nome);
        setDescricao(descricao);
        setEmpresa(empresa);
        setExclusivoEstudante(exclusivoEstudante);
        setCompetencias(competencias);
        setIdiomas(idiomas);
        setId();
        setCargo(cargo);
        setArea(area);
        setDataTermino(dataTermino);
        setPresencial(presencial);
    }

    public void notificarEmpresa(UsuarioEmpresa empresa) {
        System.out.println("Enviando notificação para " + empresa.getNome() + ".");
        // Simula notificação para a Empresa quando receber uma atualização sobre a vaga
    }

    public void notificarCandidatos(UsuarioCandidato candidato) {
        ArrayList<UsuarioCandidato> candidatos = new ArrayList<>(Arrays.asList(candidato));
        notificarCandidatos(candidatos);
        // Simula notificação para o Candidato quando receber uma atualização da vaga
    }

    public void notificarCandidatos(ArrayList<UsuarioCandidato> candidatos) {
        for (UsuarioCandidato candidato : candidatos) {
            System.out.println("Enviando notificação para " + candidato.getNome() + ".");
        }
        // Simula notificação para os Candidatos quando receber uma atualização da vaga
    }

    public int getId() {
        return id;
    }

    private void setId() {
        SecureRandom rng = new SecureRandom();
        int rgnLong = rng.nextInt();
        this.id = rgnLong;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
        this.dt_dataTermino = LocalDate.parse(dataTermino, formatoData);
    }

    public LocalDate getDt_DataTermino() {
        return dt_dataTermino;
    }

    public char getPresencial() {
        return presencial;
    }

    public void setPresencial(char presencial) {
        presencial = Character.toLowerCase(presencial);
        if (presencial == 's' || presencial == 'h') {
            this.presencial = presencial;
        } else {
            this.presencial = 'n';
        }
    }

    public Boolean isPresencial() {
        return Character.toLowerCase(presencial) == 's';
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExclusivoEstudante() {
        return exclusivoEstudante;
    }

    public void setExclusivoEstudante(boolean exclusivoEstudante) {
        this.exclusivoEstudante = exclusivoEstudante;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public UsuarioEmpresa getEmpresa() {
        return empresa;
    }

    private void setEmpresa(UsuarioEmpresa empresa) {
        this.empresa = empresa;
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
        Vaga other = (Vaga) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        String resumo = "Nome: " + getNome() + "\nDescrição: " + getDescricao() + "\nÉ exclusivo para estudantes? "
                + (isExclusivoEstudante() == true ? "Sim" : "Não") + "\nData de criação: " + getDataCriacao() + "\nData de término: " + getDataTermino()
                + "\nCargo: " + getCargo() + "\nÁrea de atuação: " + getArea()
                + "\nÉ presencial: " + (isPresencial() ? "Sim" : "Não")
                + "\nEmpresa: " + getEmpresa().getNome() + "\nCompetencias: ";

        for (Competencia competencia : getCompetencias()) {
            resumo += "\n\t" + competencia.getSoftSkill() + "\n\t" + competencia.getHardSkill();
        }

        resumo += "\nIdiomas: ";
        for (Idioma idioma : getIdiomas()) {
            resumo += "\n\t" + idioma.getNome() + " - " + idioma.getNivelProeficiencia();
        }

        return resumo;
    }

}
