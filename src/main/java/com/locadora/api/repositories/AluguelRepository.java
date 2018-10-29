package com.locadora.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.api.domain.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer>{

}
