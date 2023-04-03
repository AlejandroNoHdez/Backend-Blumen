package com.example.blumen.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blumen.models.UsuarioTieneDireccionModel;
import com.example.blumen.services.UsuarioTieneDireccionService;

@RestController
@RequestMapping("/utd/")
public class UsuarioTieneDireccionController
{
	@Autowired
	UsuarioTieneDireccionService usuarioTieneDireccionService;

	@GetMapping()
	public ArrayList<UsuarioTieneDireccionModel> mostrarUsuariosDirecciones()
	{
		return usuarioTieneDireccionService.listarUsuariosDirecciones();
	}

	@GetMapping(path = "/{id}")
	public Optional<UsuarioTieneDireccionModel> obtenerUsuarioPorId(@PathVariable("id") Long id)
	{
		return usuarioTieneDireccionService.obtenerPorId(id);
	}

	@PostMapping()
	public UsuarioTieneDireccionModel guardarUsuarioTieneDireccion(
			@RequestBody UsuarioTieneDireccionModel usuarioTieneDireccionModel)
	{
		return usuarioTieneDireccionService.guardar(usuarioTieneDireccionModel);
	}

	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id)
	{
		boolean ok = usuarioTieneDireccionService.eliminarPorId(id);
		if (ok)
		{
			return "Se elimino el usuario";
		}
		else
		{
			return "No se elimino el usuario";
		}
	}
}