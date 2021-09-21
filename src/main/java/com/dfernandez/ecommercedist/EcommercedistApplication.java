package com.dfernandez.ecommercedist;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dfernandez.ecommercedist.domain.Categoria;
import com.dfernandez.ecommercedist.domain.Cidade;
import com.dfernandez.ecommercedist.domain.Cliente;
import com.dfernandez.ecommercedist.domain.Endereco;
import com.dfernandez.ecommercedist.domain.Estado;
import com.dfernandez.ecommercedist.domain.Produto;
import com.dfernandez.ecommercedist.domain.enums.TipoCliente;
import com.dfernandez.ecommercedist.repositories.CategoriaRepository;
import com.dfernandez.ecommercedist.repositories.CidadeRepository;
import com.dfernandez.ecommercedist.repositories.ClienteRepository;
import com.dfernandez.ecommercedist.repositories.EnderecoRepository;
import com.dfernandez.ecommercedist.repositories.EstadoRepository;
import com.dfernandez.ecommercedist.repositories.ProdutoRepository;

@SpringBootApplication
public class EcommercedistApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepositor;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(EcommercedistApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepositor.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com", "11859545621", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2778-6359", "991229541"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardins", "25221160" , cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Projetada", "10", "Apto 504", "Centro", "28659987" , cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}
} 