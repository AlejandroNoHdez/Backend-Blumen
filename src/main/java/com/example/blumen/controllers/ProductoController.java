package com.example.blumen.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.blumen.models.ProductoModel;
import com.example.blumen.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
    	boolean ok = productoService.eliminarProducto(id);
    	if (ok) {
			return "Se eliminó el producto";
		} else {
			return "No se eliminó el producto";
		}
    }
    
    @GetMapping()
    public ArrayList<ProductoModel> listarProductos() {
        return productoService.listarProductos();
    }
    
    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }
    
    @GetMapping("/query")
    public ArrayList<ProductoModel> obtenerPorNombreRamo(@RequestParam("nombreRamo") String nombreRamo) {
        return productoService.obtenerPorNombreRamo(nombreRamo);
    }

    
    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Long id){
        return productoService.obtenerPorId(id);
    }
    
}