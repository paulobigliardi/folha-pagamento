package br.empresa.folha.controller;

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
import java.util.List;
import jakarta.validation.Valid;

import br.empresa.folha.model.Gerente;
import br.empresa.folha.service.GerenteService;

@RestController
@RequestMapping ("/gerentes")
public class GerenteController {
    @Autowired
    GerenteService gerenteService;

    @GetMapping
    public List <Gerente> listarTodos() {
        return gerenteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> buscarPorId(@PathVariable Long id) {
        Gerente gerente = gerenteService.buscarPorId(id);
        if(gerente == null) {
          return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(gerente);
    }

    @PostMapping
    public ResponseEntity <Gerente> salvar(@Valid @RequestBody Gerente gerente) {
        Gerente salvo = gerenteService.salvar(gerente);
        if(salvo == null) {
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.status(201).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id) {
        Gerente g = gerenteService.buscarPorId(id);
        if(g == null) {
            return ResponseEntity.notFound().build();
        }
        gerenteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Gerente> atualizar(@Valid @RequestBody Gerente gerente, @PathVariable Long id) {
        Gerente g = gerenteService.atualizar(gerente, id);
        if(g == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(g);
}
}
