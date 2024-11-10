package com.verdeflor.verdeflor.services;

import com.verdeflor.verdeflor.entities.Funcionario;
import com.verdeflor.verdeflor.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario findById(int id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById((id));
        return funcionario.orElse(null);
    }

    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Funcionario gravarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(Integer id, Funcionario funcionario) {
        Funcionario alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(funcionario.getNome());
            alterado.setCpf(funcionario.getCpf());
            alterado.setDtAdmissao(funcionario.getDtAdmissao());
        }
        return funcionarioRepository.save(funcionario);
    }
}
