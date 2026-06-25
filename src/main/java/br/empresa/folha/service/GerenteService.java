package br.empresa.folha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.empresa.folha.model.Gerente;
import br.empresa.folha.repository.GerenteRepository;

@Service
public class GerenteService {
    
     public void descontoINSS() {
        
        List<Gerente> gerentes = gerenteRepository.findAll();
        
        for (Gerente gerente : gerentes) {
        Double inss = 0.0;
        Double salario = gerente.getSalario();
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
        gerente.setImposto(inss);
        double liquido = funcionarioService.salarioLiquido(salario, inss,0.0);
        gerente.setSalarioLiquido(liquido);
        gerenteRepository.save(gerente);
}
    }
    
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
        
        Gerente salvo = gerenteRepository.save(gerente);
        descontoINSS();
        return salvo;
    }

    public void deletar(Long id) {
        if(id == null) return;
        gerenteRepository.deleteById(id);
    }

    public Gerente atualizar(Gerente gerente, Long id) {
        if(gerente == null || id == null) return null;
        Gerente atualizacao = gerenteRepository.findById(id).orElse(null);
        atualizacao.setNome(gerente.getNome());
        atualizacao.setSalario(gerente.getSalario());
        atualizacao.setBonus(gerente.getBonus());
        gerenteRepository.save(atualizacao);
        descontoINSS();
        return atualizacao;
    }

}
