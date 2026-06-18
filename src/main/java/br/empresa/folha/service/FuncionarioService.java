package br.empresa.folha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.empresa.folha.model.Funcionario;
import br.empresa.folha.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    public void calcular(Funcionario funcionario) {
        Double imposto = funcionario.getSalario() * 0.09;
        Double salarioLiquido = funcionario.getSalario() - imposto;
        funcionario.setImposto(imposto);
        funcionario.setSalarioLiquido(salarioLiquido);
    }

    public double salarioLiquido(Double salario, Double imposto, Double salarioLiquido) {
        salarioLiquido = salario - imposto;
        return salarioLiquido;
    }


    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List <Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }
    
    public Funcionario buscarPorId(Long id) {
        if (id == null) return null;
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario salvar(Funcionario funcionario) {
        if (funcionario == null) return null;
        calcular(funcionario);
        return funcionarioRepository.save(funcionario);
    }
    public void deletar(Long id) {
        if (id == null) return;
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        if(id == null || funcionario == null) return null;
        Funcionario atualizacao = funcionarioRepository.findById(id).orElse(null);
        if (atualizacao == null) return null;
        calcular(funcionario);
        atualizacao.setNome(funcionario.getNome());
        atualizacao.setSalario(funcionario.getSalario());
        return funcionarioRepository.save(atualizacao);
    }
}
