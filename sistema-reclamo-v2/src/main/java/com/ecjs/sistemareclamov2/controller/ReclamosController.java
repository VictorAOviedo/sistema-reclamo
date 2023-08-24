package com.ecjs.sistemareclamov2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecjs.sistemareclamov2.bo.Reclamo;
import com.ecjs.sistemareclamov2.controller.forms.FormReclamo;
import com.ecjs.sistemareclamov2.service.ReclamosService;



@Controller
@RequestMapping("/reclamos")
public class ReclamosController {
	
	@Autowired
	private ReclamosService reclamosService;
	
	// URL FINAL => /reclamos/listar
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de los reclamos en el sistema");
		List<Reclamo> reclamos = reclamosService.recuperarTodoLosReclamos();
		model.addAttribute("reclamos", reclamos);
		return "/reclamos/listar";
	}


	// URL FINAL => /reclamos/ver/{el id del reclamo}
	@RequestMapping("/ver/{id}")
	public String ver(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamosService.recuperarReclamoPorId(id);
		model.addAttribute("reclamo", reclamo);
		return "/reclamos/ver";
	}

	@RequestMapping("/borrar/{id}")
	public String borrar(Model model, @PathVariable Long id) {
		reclamosService.borrarReclamo(id);
		return "redirect:/reclamos/listar"; //VUELVO A LLAMAR AL METODO LISTAR DESPUES DE BORRAR ESO ES EL REDIRECT!!!!
	}
	
	
	// URL FINAL => /reclamos/nuevo
	@RequestMapping("/nuevo")
	public String nuevo(Model model) {
		FormReclamo formReclamo = new FormReclamo();
		model.addAttribute("formReclamo", formReclamo);
		return "/reclamos/form";
	}
	

/*	@RequestMapping(value = "/guardarnuevo", method = RequestMethod.POST)
	public String guardarNuevo(Model model, FormReclamo formReclamo) {
		Reclamo reclamo = new Reclamo();
		
		reclamo.setTitulo(formReclamo.getTitulo());
		reclamo.setDescripcion(formReclamo.getDescripcion());
		reclamosService.crearNuevoReclamo(reclamo);
		
		return  "redirect:/reclamos/listar";
	}*/

	@RequestMapping("/editar/{id}")
	public String editar(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamosService.recuperarReclamoPorId(id);
		FormReclamo formReclamo = new FormReclamo();
		formReclamo.setId(reclamo.getId());
		formReclamo.setTitulo(reclamo.getTitulo());
		formReclamo.setDescripcion(reclamo.getDescripcion());
		model.addAttribute("formReclamo", formReclamo);
		return "/reclamos/form";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(Model model, FormReclamo formReclamo) {
		
		Long idActual = formReclamo.getId();
		Reclamo reclamo = null;
		
		if(idActual != null) {
			reclamo = reclamosService.recuperarReclamoPorId(idActual);
		} else {
			reclamo = new Reclamo();
		}
		
		reclamo.setTitulo(formReclamo.getTitulo());
		reclamo.setDescripcion(formReclamo.getDescripcion());
		
		if(idActual != null) {
			reclamosService.actualizarReclamo(reclamo);
		} else {
			reclamosService.crearNuevoReclamo(reclamo);
		}
		
		return  "redirect:/reclamos/listar";
	}

}
