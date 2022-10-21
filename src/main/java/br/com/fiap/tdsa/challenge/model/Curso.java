package br.com.fiap.tdsa.challenge.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Curso {
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int id;
    private String nome;
    private LocalDate dt_dataInicio;
    private LocalDate dt_dataTermino;
    private String dataInicio;
    private String dataTermino;
    private int numero;
    private String orgEmissora;

    public Curso(String nome, String dataInicio, String dataTermino) {
        setNome(nome);
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
        this.dt_dataInicio = LocalDate.parse(dataInicio, formatoData);
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOrgEmissora(String orgEmissora) {
        this.orgEmissora = orgEmissora;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
        this.dt_dataTermino = LocalDate.parse(dataTermino, formatoData);
    }


}
