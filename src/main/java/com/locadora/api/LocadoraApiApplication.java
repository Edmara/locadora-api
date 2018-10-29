package com.locadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.locadora.api.repositories.MarcaRepository;
import com.locadora.api.repositories.VeiculoRepository;

@SpringBootApplication
public class LocadoraApiApplication implements CommandLineRunner {

	@Autowired
	MarcaRepository marcaRepository;
	VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
