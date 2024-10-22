package com.solarwise.api.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PESSOA_JURIDICA")
public class UserPessoaJuridica extends User {

 
	private static final long serialVersionUID = 1L;
	@NotBlank
    private String cnpj;

   
    public UserPessoaJuridica(Long id, String name, String email, String password,  String cnpj) {
		super(id, name, email, password);
        this.cnpj = cnpj;
    }
}
