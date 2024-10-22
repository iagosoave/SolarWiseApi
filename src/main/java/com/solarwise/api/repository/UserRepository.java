package com.solarwise.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solarwise.api.models.User;
import com.solarwise.api.models.UserPessoaFisica;
import com.solarwise.api.models.UserPessoaJuridica;

@Repository // Define essa interface como um repositório Spring
public interface UserRepository extends JpaRepository<User, Long> {

    // Método para encontrar um usuário pelo email
    Optional<User> findByEmail(String email);

    // Método para encontrar um usuário Pessoa Física pelo CPF
    Optional<UserPessoaFisica> findByCpf(String cpf);

    // Método para encontrar um usuário Pessoa Jurídica pelo CNPJ
    Optional<UserPessoaJuridica> findByCnpj(String cnpj);
}
