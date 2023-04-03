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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blumen.models.DireccionModel;
import com.example.blumen.services.DireccionService;


@RestController
@RequestMapping("/direccion")
public class DireccionController {
    @Autowired
    DireccionService direccionService;
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
    	boolean ok = direccionService.eliminarDireccion(id);
    	if (ok) {
			return "Se elimino la direccion";
		} else {
			return "No se elimino la direccion";
		}
    }
    
    @GetMapping()
    public ArrayList<DireccionModel> listarDirecciones() {
        return direccionService.listarDirecciones();
    }
    @PostMapping()
    public DireccionModel guardarDireccion(@RequestBody DireccionModel direccionModel) {
        return direccionService.guardarDireccion(direccionModel);
    }
    @GetMapping("/findbycp")
    public ArrayList<DireccionModel> obtenerPorCodigoP(@RequestParam("cp") String codigoP) {
        return direccionService.obtenerPorCodigoP(codigoP);
    }
    @GetMapping(path = "/{id}")
    public Optional<DireccionModel> obtenerDireccionPorId(@PathVariable ("id")Long id){
        return direccionService.obtenerPorId(id);
    }
}