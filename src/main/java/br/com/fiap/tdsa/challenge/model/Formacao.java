package br.com.fiap.tdsa.challenge.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Formacao {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private String nomeInstituicao;
    private LocalDate dt_dataInicio;
    private LocalDate dt_dataTermino;
    private String dataInicio;
    private String dataTermino;
    private String descricao;
    private String notas;
    private String atividades;
    private String area;
    private String diploma;
    private String midiaInstituicao;

    public Formacao(String nomeInstituicao, String dataInicio, String dataTermino) {
        setNomeInstituicao(nomeInstituicao);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
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

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public LocalDate getDt_DataInicio() {
        return dt_dataInicio;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
        this.dt_dataInicio = LocalDate.parse(dataInicio, formatoData);
    }

    public LocalDate getDt_DataTermino() {
        return dt_dataTermino;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
        this.dt_dataTermino = LocalDate.parse(dataTermino, formatoData);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getMidiaInstituicao() {
        return midiaInstituicao;
    }

    public void setMidiaInstituicao(String midiaInstituicao) {
        this.midiaInstituicao = midiaInstituicao;
    }

    @Override
    public String toString() {
        return "Nome da Instituição: " + getNomeInstituicao() + "\nData de início: " + getDataInicio()
                + "\nData de término: " + getDataTermino() + "\nDescrição: " + getDescricao()
                + "\nNotas: " + getNotas() + "\nAtividades: " + getAtividades() + "\nÁrea: " + getArea()
                + "\nDiploma: " + getDiploma() + "\nMídia da Instituição: " + getMidiaInstituicao();
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
        Formacao other = (Formacao) obj;
        return Objects.equals(id, other.id);
    }

}
