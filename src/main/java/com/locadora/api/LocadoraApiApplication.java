package com.locadora.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.domain.Marca;
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

		Marca chevrolet = new Marca(null, "Chevrolet");
		Marca renault = new Marca(null, "Renault");
		Marca honda = new Marca(null, "Honda");
		Marca volkswagen = new Marca(null, "Volkswagen");
		Marca fiat = new Marca(null, "Fiat");
		Marca toyota = new Marca(null, "Toyota");
		Marca kia = new Marca(null, "Kia");
		Marca hyundai = new Marca(null, "Hyundai");
		
//		Veiculo corsa = new Veiculo(null, "Corsa", "VFT-2526", "90,00");
//		
//		chevrolet.getVeiculos().add(corsa);
//		
//		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		
//		veiculoRepository.save(corsa);
		marcaRepository.saveAll(Arrays.asList(chevrolet, renault, honda, volkswagen, fiat, toyota, kia, hyundai));

	}

}
