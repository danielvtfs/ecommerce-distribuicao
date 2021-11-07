package com.dfernandez.ecommercedist.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dfernandez.ecommercedist.domain.Cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Nome é obrigatório!")
	@Length(min=5, max=80, message = "O nome deve ter entre 5 e 80 caracteres!")
	private String nome;
	
	@NotEmpty(message = "E-mail é obrigatório!")
	@Email(message = "E-mail inválido!")
	private String email;
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId(); 
		nome = obj.getNome();
		email = obj.getEmail();
	}
}
