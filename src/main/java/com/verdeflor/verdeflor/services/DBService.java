package com.verdeflor.verdeflor.services;

import com.verdeflor.verdeflor.entities.Funcionario;
import com.verdeflor.verdeflor.entities.User;
import com.verdeflor.verdeflor.repositories.FuncionarioRepository;
import com.verdeflor.verdeflor.repositories.UserRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UserRepository userRepository;


    @Bean
    public void instanciarDB() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Funcionario funcionario = new Funcionario("João", "111.111.111.11", 2000, new Date());
        User user = new User("admin@gmail.com", "@admin123");
        funcionarioRepository.saveAll(Arrays.asList(funcionario));
        userRepository.saveAll(Arrays.asList(user));
    }
}
