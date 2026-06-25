package br.empresa.folha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.empresa.folha.model.Funcionario;
import br.empresa.folha.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    public void descontoINSS() {
        
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        
        for (Funcionario funcionario : funcionarios) {
        Double inss = 0.0;
        Double salario = funcionario.getSalario();
        if (salario <= 1621.00) {
            inss += salario * 0.075;                          

        } else if (salario <= 2902.84) {
            inss += 1621.00 * 0.075;                          
            inss += (salario - 1621.00) * 0.09;                     

        } else if (salario <= 4354.27) {
            inss += 1621.00 * 0.075;                          
            inss += (2902.84 - 1621.00) * 0.09;                     
            inss += (salario - 2902.84) * 0.12;                     

        } else if (salario <= 8475.55) {
            inss += 1621.00 * 0.075;                          
            inss += (2902.84 - 1621.00) * 0.09;                     
            inss += (4354.27 - 2902.84) * 0.12;                      
            inss += (salario - 4354.27) * 0.14;                   
        }
        funcionario.setImposto(inss);
        double liquido = salarioLiquido(salario, inss, 0.0);
        funcionario.setSalarioLiquido(liquido);
        funcionarioRepository.save(funcionario);
}
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
       
        Funcionario salvo = funcionarioRepository.save(funcionario);
         descontoINSS();
         return salvo;
    }
    public void deletar(Long id) {
        if (id == null) return;
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        if(id == null || funcionario == null) return null;
        Funcionario atualizacao = funcionarioRepository.findById(id).orElse(null);
        if (atualizacao == null) return null;
        
        atualizacao.setNome(funcionario.getNome());
        atualizacao.setSalario(funcionario.getSalario());
        funcionarioRepository.save(atualizacao);
        descontoINSS();
        return atualizacao;
    }
}
