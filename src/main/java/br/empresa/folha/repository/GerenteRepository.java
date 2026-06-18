package br.empresa.folha.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.empresa.folha.model.Gerente;

public interface GerenteRepository extends JpaRepository <Gerente,Long>  {
    
}
