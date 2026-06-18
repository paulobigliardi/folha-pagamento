package br.empresa.folha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import br.empresa.folha.model.Funcionario;
import br.empresa.folha.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }
    
    @PostMapping
    public ResponseEntity<Funcionario> salvar(@Valid @RequestBody Funcionario f) {
       Funcionario salvo = funcionarioService.salvar(f);
        if (salvo == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
        Funcionario f = funcionarioService.buscarPorId(id);
        if (f == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(f);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Funcionario f = funcionarioService.buscarPorId(id);
        if (f == null) {
           return ResponseEntity.notFound().build();
        }
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario f =  funcionarioService.atualizar(id, funcionario);
        if (f == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(f);
    }
}
