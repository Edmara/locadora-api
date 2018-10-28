package com.locadora.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.api.domain.Marca;
import com.locadora.api.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
