package com.verdeflor.verdeflor.resources;

import com.verdeflor.verdeflor.entities.Funcionario;
import com.verdeflor.verdeflor.services.FuncionarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping(value = "funcionarios")

public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    public FuncionarioResource (FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return funcionarios;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<Funcionario>> findByNome(@PathVariable String nome) {
        List<Funcionario> funcionarios = funcionarioService.findByNome(nome);
        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping(value = "/ativos")
    public ResponseEntity<List<Funcionario>> findAtivos() {
        List<Funcionario> ativos = funcionarioService.findAtivos();
        return ResponseEntity.ok().body(ativos);
    }

    @GetMapping(value = "/inativos")
    public ResponseEntity<List<Funcionario>> findInativos() {
        List<Funcionario> inativos = funcionarioService.findInativos();
        return ResponseEntity.ok().body(inativos);
    }

    @PostMapping
    public ResponseEntity<Funcionario> gravarFuncionario (@RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.gravarFuncionario(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deletarFuncionario (@PathVariable Integer id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario (@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
        funcionario = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok().body(funcionario);
    }


}
