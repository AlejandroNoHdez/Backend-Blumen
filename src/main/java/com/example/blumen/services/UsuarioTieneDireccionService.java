package com.example.blumen.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blumen.models.UsuarioTieneDireccionModel;
import com.example.blumen.repositories.UsuarioTieneDireccionRepository;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsuarioTieneDireccionService
{

	@Autowired
	UsuarioTieneDireccionRepository usuarioTieneDireccionRepo;

	// Post
	public UsuarioTieneDireccionModel guardar(UsuarioTieneDireccionModel usuarioTieneDireccionModel)
	{
		return usuarioTieneDireccionRepo.save(usuarioTieneDireccionModel);
	}

	// Get All
	public ArrayList<UsuarioTieneDireccionModel> listarUsuariosDirecciones()
	{
		return (ArrayList<UsuarioTieneDireccionModel>) usuarioTieneDireccionRepo.findAll();
	}

	// Get by Id
	public Optional<UsuarioTieneDireccionModel> obtenerPorId(Long id)
	{
		return usuarioTieneDireccionRepo.findById(id);
	}

	// Delete
	public boolean eliminarPorId(Long id)
	{
		try
		{
			usuarioTieneDireccionRepo.deleteById(id);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}
}