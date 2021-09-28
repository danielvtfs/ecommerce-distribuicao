package com.dfernandez.ecommercedist.domain.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	private EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
			if (codigo.equals(estadoPagamento.getCodigo())) {
				return estadoPagamento;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
}