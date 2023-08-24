package com.ecjs.sistemareclamov2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecjs.sistemareclamov2.bo.Cliente;



@Repository
public interface ClientesRepository extends CrudRepository<Cliente, Long>{

	@Query(value = "select c from Cliente c")
	public List<Cliente> buscarTodosLosClientes();

	
	@Query(value = "select c from Cliente c where c.nombre = :nombre")
	public List<Cliente> buscarClientesPorNombre(@Param("nombre") String nombre);

	@Query(value = "select c from Cliente c where c.nombre like %:nombreLike%")
	public List<Cliente> buscarClientesPorNombreLike(@Param("nombreLike") String nombre);
	
}
