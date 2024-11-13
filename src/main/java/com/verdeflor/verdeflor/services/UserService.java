package com.verdeflor.verdeflor.services;

import com.verdeflor.verdeflor.entities.User;
import com.verdeflor.verdeflor.repositories.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String senha) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getSenha().equals(senha);
    }

}
