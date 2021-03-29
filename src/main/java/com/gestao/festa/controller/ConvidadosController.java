package com.gestao.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.festa.model.Convidado;
import com.gestao.festa.repository.Convidados;

@Controller
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	@GetMapping("/convidados" )
	public ModelAndView listar() {
			
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;

	}
	
	

	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		
		this.convidados.save(convidado);
		return "redirect:/convidados";
		
	}

}