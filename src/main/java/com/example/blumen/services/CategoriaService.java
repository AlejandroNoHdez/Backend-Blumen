package com.example.blumen.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blumen.models.CategoriaModel;
import com.example.blumen.repositories.CategoriaRepository;


//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    
    public boolean eliminarCategoria(Long id) {
    	try {
    		categoriaRepository.deleteById(id);
        	return true; 
		} catch (Exception e) {
			return false;
		}
    }

    public ArrayList<CategoriaModel> listarCategorias() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }
    
    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }
    
     public ArrayList<CategoriaModel> obtenerPorNombre (String nombre) {
      return categoriaRepository.findByNombre(nombre); 
      }
     
     public Optional<CategoriaModel> obtenerPorId (Long id){
         return categoriaRepository.findById(id);
     }
}