package com.example.blumen.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blumen.models.CategoriaModel;
import com.example.blumen.services.CategoriaService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@RestController
@RequestMapping("/categoria")
public class CategoriaController
{
	@Autowired
	CategoriaService categoriaService;

	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id)
	{
		boolean ok = categoriaService.eliminarCategoria(id);
		if (ok)
		{
			return "Se elimino la categoria";
		}
		else
		{
			return "No se elimino la categoria";
		}
	}

	@GetMapping()
	public ArrayList<CategoriaModel> listarCategorias()
	{
		return categoriaService.listarCategorias();
	}

	@PostMapping()
	public CategoriaModel guardarCategoria(@RequestBody CategoriaModel categoriaModel)
	{
		return categoriaService.guardarCategoria(categoriaModel);
	}

	@GetMapping("/findbyname")
	public ArrayList<CategoriaModel> obtenerPorNombre(@RequestParam("nombre") String nombre)
	{
		return categoriaService.obtenerPorNombre(nombre);
	}

	@GetMapping(path = "/{id}")
	public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id") Long id)
	{
		return categoriaService.obtenerPorId(id);
	}
}