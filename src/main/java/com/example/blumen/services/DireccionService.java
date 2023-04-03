package com.example.blumen.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blumen.models.DireccionModel;
import com.example.blumen.repositories.DireccionRepository;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DireccionService {

	@Autowired
	DireccionRepository direccionRepository;

	public boolean eliminarDireccion(Long id) {
		try {
			direccionRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<DireccionModel> listarDirecciones() {
		return (ArrayList<DireccionModel>) direccionRepository.findAll();
	}

	public DireccionModel guardarDireccion(DireccionModel direccion) {
		return direccionRepository.save(direccion);
	}

	public ArrayList<DireccionModel> obtenerPorCodigoP(String codigoP) {
		return direccionRepository.findByCodigoPostal(codigoP);
	}

	public Optional<DireccionModel> obtenerPorId(Long id) {
		return direccionRepository.findById(id);
	}
}