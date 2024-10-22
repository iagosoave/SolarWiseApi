package com.solarwise.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.solarwise.api.models.User;
import com.solarwise.api.models.UserPessoaFisica;
import com.solarwise.api.models.UserPessoaJuridica;
import com.solarwise.api.repository.UserRepository;

@Service // Define essa classe como um serviço gerenciado pelo Spring
public class UserPessoaService {

    @Autowired // Injeta o repositório para realizar operações no banco de dados
    private UserRepository userRepository;

    @Autowired // Injeta o PasswordEncoder para codificar as senhas dos usuários
    private PasswordEncoder passwordEncoder;

    // Método para registrar um usuário Pessoa Física
    public User registerPessoaFisica(UserPessoaFisica user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Codifica a senha antes de salvar
        return userRepository.save(user); // Salva o usuário no banco de dados
    }

    // Método para registrar um usuário Pessoa Jurídica
    public User registerPessoaJuridica(UserPessoaJuridica user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Codifica a senha antes de salvar
        return userRepository.save(user); // Salva o usuário no banco de dados
    }

    // Busca um usuário no banco de dados pelo email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email); // Retorna um Optional contendo o usuário, se existir
    }

    // Verifica se a senha fornecida é igual à senha codificada armazenada
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword); // Compara a senha fornecida com a senha codificada
    }
}
