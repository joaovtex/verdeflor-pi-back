package com.verdeflor.verdeflor.repositories;

import com.verdeflor.verdeflor.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM funcionarios f WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Funcionario> findByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("SELECT f FROM funcionarios f WHERE f.estaAtivo = true")
    List<Funcionario> findAllAtivos();

    @Query("SELECT f FROM funcionarios f WHERE f.estaAtivo = false")
    List<Funcionario> findAllInativos();
}
