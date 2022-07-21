package com.bolsaideas.springboot.form.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import com.bolsaideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario") //guarda en una sesion http
public class FormController {

	@Autowired
	private UsuarioValidador validador;
	
	//metodos handler
	
	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		
		binder.addValidators(validador); //validamos el formulario
	}
	
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("David");
		usuario.setApellido("Rivera");
		usuario.setIdentificador("123.456.789-k");
		
		model.addAttribute("titulo", "formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario,BindingResult result,Model model, SessionStatus status) { //importante este orden
			
		
		
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			
	
			return "form";
		}
				
		model.addAttribute("usuario", usuario); //pasamos el usuario a la vista
		
		status.setComplete(); //elimina el objeto usuario de la sesion
		
		return "resultado";
	}
}
