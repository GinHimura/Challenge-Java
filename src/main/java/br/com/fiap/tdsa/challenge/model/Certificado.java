package br.com.fiap.tdsa.challenge.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Certificado {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private String nome;
    private LocalDate dt_dataInicio;
    private LocalDate dt_dataTermino;
    private String dataInicio;
    private String dataTermino;
    private String descricao;
    private String orgEmissora;
    private String credencial;
    private String urlCredencial;

    public Certificado(String nome, String dataInicio, String dataTermino) {
        setNome(nome);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        setId();
    }

    private void setId() {
        SecureRandom rng = new SecureRandom();
        int rgnInt = rng.nextInt();
        this.id = rgnInt;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
        this.dt_dataInicio = LocalDate.parse(dataInicio, formatoData);
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
        this.dt_dataTermino = LocalDate.parse(dataTermino, formatoData);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrgEmissora(String orgEmissora) {
        this.orgEmissora = orgEmissora;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public void setUrlCredencial(String urlCredencial) {
        this.urlCredencial = urlCredencial;
    }

}