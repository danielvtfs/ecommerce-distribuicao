package com.dfernandez.ecommercedist;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dfernandez.ecommercedist.domain.Categoria;
import com.dfernandez.ecommercedist.repositories.CategoriaRepository;

@SpringBootApplication
public class EcommercedistApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommercedistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
