package com.locadora.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.api.domain.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
