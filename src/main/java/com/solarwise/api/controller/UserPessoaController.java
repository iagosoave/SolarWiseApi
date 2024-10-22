package com.solarwise.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solarwise.api.models.User;
import com.solarwise.api.models.UserPessoaFisica;
import com.solarwise.api.models.UserPessoaJuridica;
import com.solarwise.api.service.UserPessoaService;

@RestController
@RequestMapping("/api/users")
public class UserPessoaController {

    @Autowired
    private UserPessoaService userPessoaService;

    // Endpoint para registrar um usuário Pessoa Física
    @PostMapping("/register/fisica")
    public ResponseEntity<?> registerPessoaFisica(@RequestBody UserPessoaFisica user) {
        User newUser = userPessoaService.registerPessoaFisica(user); 
        return ResponseEntity.ok(newUser); // Retorna o novo usuário
    }

    // Endpoint para registrar um usuário Pessoa Jurídica
    @PostMapping("/register/juridica")
    public ResponseEntity<?> registerPessoaJuridica(@RequestBody UserPessoaJuridica user) {
        User newUser = userPessoaService.registerPessoaJuridica(user);
        return ResponseEntity.ok(newUser); // Retorna o novo usuário
    }

    // Endpoint para login de usuários
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userPessoaService.findByEmail(email); 
        if (user.isPresent() && userPessoaService.checkPassword(password, user.get().getPassword())) {
            return ResponseEntity.ok("Login successful"); // Login bem-sucedido
        } else {
            return ResponseEntity.status(401).body("Invalid email or password"); // Retorna erro se as credenciais forem inválidas
        }
    }
}
