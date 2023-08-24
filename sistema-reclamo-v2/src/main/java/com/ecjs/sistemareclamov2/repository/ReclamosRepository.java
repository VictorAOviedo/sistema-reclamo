package com.ecjs.sistemareclamov2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecjs.sistemareclamov2.bo.Reclamo;



@Repository
public interface ReclamosRepository extends CrudRepository<Reclamo, Long>{
	
	@Query(value = "select r from Reclamo r")
	public List<Reclamo> buscarTodosLosReclamos();
	
}
