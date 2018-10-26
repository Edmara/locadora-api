package com.locadora.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.api.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
