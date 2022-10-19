package br.com.candidate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {
    private String nome;
    private String descricao;
    private Date criacao;
    private Boolean presencial;
    private String qualificacao;
    private String salario;
    private String tipoVaga;
}
