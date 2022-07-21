package com.bolsaideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsaideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Usuario.class.isAssignableFrom(clazz); //comprobar que vamos a validar este objeto
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre"); //verificamos el atributo que vamos a validar.Ponemos el del messaje properties
		
			if(usuario.getIdentificador().matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")==false) {
				
				errors.rejectValue("identificador", "pattern.usuario.identificador");
			}
		
		
	}

}
