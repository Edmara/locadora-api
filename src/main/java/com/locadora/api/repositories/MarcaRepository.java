package com.locadora.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.api.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
