package com.ecjs.sistemareclamov2.service;

import java.util.List;

import com.ecjs.sistemareclamov2.bo.Reclamo;



public interface ReclamosService {

	Long crearNuevoReclamo(Reclamo reclamo);

	Reclamo recuperarReclamoPorId(Long id);

	List<Reclamo> recuperarTodoLosReclamos();
	
	void borrarReclamo(Long id);

	void actualizarReclamo(Reclamo reclamo);
	
}
