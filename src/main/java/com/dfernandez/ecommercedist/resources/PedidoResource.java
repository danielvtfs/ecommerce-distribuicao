package com.dfernandez.ecommercedist.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dfernandez.ecommercedist.domain.Pedido;
import com.dfernandez.ecommercedist.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService categoriaService;
	
	
	//@PathVariable para o parâmetro id receber o /{id}
	//ResponseEntity encapsula as respostas http para o serviço rest
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido categoria = categoriaService.find(id);
		return ResponseEntity.ok().body(categoria);

	}
}
