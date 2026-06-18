package br.empresa.folha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.empresa.folha.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    
}
