package com.dfernandez.ecommercedist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dfernandez.ecommercedist.domain.Categoria;

@SpringBootApplication
public class EcommercedistApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EcommercedistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria();
		
	}

}
