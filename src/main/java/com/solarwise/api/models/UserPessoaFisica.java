package com.solarwise.api.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PESSOA_FISICA")
public class UserPessoaFisica extends User {

    static final long serialVersionUID = 1L;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    public UserPessoaFisica(Long id, String name, String email, String password, String cpf) {
        super(id, name, email, password);
        this.cpf = cpf;
    }
}
