package br.com.candidate.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateLoggedDTO {

    private Integer id;
    private String nome;
    private Boolean cadidato;
}
