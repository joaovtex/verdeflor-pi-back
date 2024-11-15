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

        Date dataJoao = formato.parse("20/10/2023");
        Date dataRaissa = formato.parse("03/11/2022");
        Date dataMaria = formato.parse("01/12/2021");

        Funcionario funcionario = new Funcionario("João Victor Farias", "487.916.708-88", 1823, dataJoao, true);
        Funcionario funcionario2 = new Funcionario("Raissa Casilla", "455.152.870-61", 1954, dataRaissa, true);
        Funcionario funcionario3 = new Funcionario("Maria Mercedes Rodrigues", "547.860.370-87", 2043, dataMaria, false);

        User user = new User("admin@gmail.com", "@admin123");

        funcionarioRepository.saveAll(Arrays.asList(funcionario, funcionario2, funcionario3));
        userRepository.saveAll(Arrays.asList(user));
    }
}
