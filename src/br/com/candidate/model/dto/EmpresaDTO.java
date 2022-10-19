package br.com.candidate.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDTO {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String descricao;
    private String webSite;
}
