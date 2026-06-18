package br.empresa.folha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.empresa.folha.model.Gerente;
import br.empresa.folha.repository.GerenteRepository;

@Service
public class GerenteService {
    
    @Autowired
    GerenteRepository gerenteRepository;

    @Autowired
    FuncionarioService funcionarioService;
    

    public List <Gerente> listarTodos() {
        return gerenteRepository.findAll();
    }

    public Gerente buscarPorId(Long id) {
        if (id == null) return null;
        return gerenteRepository.findById(id).orElse(null);
    }

    public Gerente salvar(Gerente gerente) {
        if(gerente == null) return null;
        funcionarioService.calcular(gerente);
        return gerenteRepository.save(gerente);
    }

    public void deletar(Long id) {
        if(id == null) return;
        gerenteRepository.deleteById(id);
    }

    public Gerente atualizar(Gerente gerente, Long id) {
        if(gerente == null || id == null) return null;
        funcionarioService.calcular(gerente);
        Gerente atualizacao = gerenteRepository.findById(id).orElse(null);
        atualizacao.setNome(gerente.getNome());
        atualizacao.setSalario(gerente.getSalario());
        atualizacao.setBonus(gerente.getBonus());
        return gerenteRepository.save(atualizacao);
    }

}
