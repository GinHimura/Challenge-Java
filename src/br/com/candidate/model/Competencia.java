package br.com.candidate.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.SecureRandom;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Competencia {
    private int id;
    private String softSkill;
    private String hardSkill;

    public Competencia(String softSkill, String hardSkill) {
        setSoftSkill(softSkill);
        setHardSkill(hardSkill);
        setId();
    }

    private void setId() {
        SecureRandom rng = new SecureRandom();
        int rgnInt = rng.nextInt();
        this.id = rgnInt;
    }


    private void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public void setHardSkill(String hardSkill) {
        this.hardSkill = hardSkill;
    }

}
