package com.bolsaideas.springboot.form.app.models.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bolsaideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolsaideas.springboot.form.app.validation.Requerido;

public class Usuario {

	//@Pattern(regexp="[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}") //formato de la id
	@IdentificadorRegex //anotacion personalizada
	private String identificador;
	
	//@NotEmpty
	private String nombre;
	
	//@NotEmpty
	@Requerido
	private String apellido;
	
	@NotEmpty//campo requerido
	@Size(min=3, max=8)
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email(message="formato incorrecto")
	private String email;
	
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@DateTimeFormat(pattern ="YYYY/MM/DD")
	private Date fechanacimiento;
	
	
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Integer getCuenta() {
		return cuenta;
	}
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
