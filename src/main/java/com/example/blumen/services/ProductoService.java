package com.example.blumen.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blumen.models.ProductoModel;
import com.example.blumen.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    
    public boolean eliminarProducto(Long id) {
    	try {
    		productoRepository.deleteById(id);
        	return true; 
		} catch (Exception e) {
			return false;
		}
    }

    public ArrayList<ProductoModel> listarProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }
    
    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }
    
     public ArrayList<ProductoModel> obtenerPorNombreRamo (String nombreRamo) {
      return productoRepository.findByNombreRamo(nombreRamo); 
      }
     
     public Optional<ProductoModel> obtenerPorId (Long id){
         return productoRepository.findById(id);
     }
}