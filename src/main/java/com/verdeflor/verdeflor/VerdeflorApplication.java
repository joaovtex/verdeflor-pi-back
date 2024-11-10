package com.verdeflor.verdeflor;

import com.verdeflor.verdeflor.repositories.FuncionarioRepository;
import com.verdeflor.verdeflor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerdeflorApplication {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	public static void main(String[] args) {
		SpringApplication.run(VerdeflorApplication.class, args);
	}

}
