package com.dfernandez.ecommercedist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dfernandez.ecommercedist.domain.Categoria;
import com.dfernandez.ecommercedist.repositories.CategoriaRepository;
import com.dfernandez.ecommercedist.services.exceptions.DataIntegrityException;
import com.dfernandez.ecommercedist.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);//setId null para que o método save considere insert e não update
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir categoria que tenha produto ");
		}
		
		
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
