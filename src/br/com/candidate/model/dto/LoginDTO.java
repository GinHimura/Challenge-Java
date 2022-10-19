package br.com.candidate.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginDTO {

    private String email;
    private String senha;
    private Boolean isCandidate;
}
