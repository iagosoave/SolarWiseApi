package com.solarwise.api.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solarwise.api.models.User;
import com.solarwise.api.repository.UserRepository;

@Service // Define essa classe como um serviço gerenciado pelo Spring
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired // Injeta o repositório de usuários
    private UserRepository userRepository;

    // Método para carregar um usuário pelo email (usado como "username" para login)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email); // Busca o usuário pelo email
        
        if (user.isPresent()) {
            // Cria um objeto UserDetails a partir do usuário encontrado
            return new org.springframework.security.core.userdetails.User(
                user.get().getEmail(),
                user.get().getPassword(),
                user.get().getRoles() // Papeis do usuário (autoridades)
            );
        } else {
            // Se o usuário não for encontrado, lança uma exceção
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
