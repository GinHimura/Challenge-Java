package br.com.candidate.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidatoDTO {

    private String email;
    private String nome;
    private String senha;
    private String nrTelefone;
    private Boolean stEstudante;
    private Date dataNascimento;
    private String genero;

}
