package com.dfernandez.ecommercedist.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dfernandez.ecommercedist.domain.Cliente;
import com.dfernandez.ecommercedist.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService categoriaService;
	
	
	//@PathVariable para o parâmetro id receber o /{id}
	//ResponseEntity encapsula as respostas http para o serviço rest
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente categoria = categoriaService.find(id);
		return ResponseEntity.ok().body(categoria);

	}
}
