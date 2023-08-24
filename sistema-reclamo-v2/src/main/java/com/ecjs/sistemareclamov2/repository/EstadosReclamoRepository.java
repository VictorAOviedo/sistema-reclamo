package com.ecjs.sistemareclamov2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecjs.sistemareclamov2.bo.EstadoReclamo;



@Repository
public interface EstadosReclamoRepository extends CrudRepository<EstadoReclamo, Long>{

}
