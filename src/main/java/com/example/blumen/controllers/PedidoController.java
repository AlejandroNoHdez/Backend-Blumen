package com.example.blumen.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blumen.models.PedidoModel;
import com.example.blumen.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
    	boolean ok = pedidoService.eliminarPedido(id);
    	if (ok) {
			return "Se elimino el pedido";
		} else {
			return "No se elimino el pedido";
		}
    }
    
    @GetMapping()
    public ArrayList<PedidoModel> listarPedidos() {
        return pedidoService.listarPedidos();
    }
    @PostMapping()
    public PedidoModel guardarPedido(@RequestBody PedidoModel pedidomodelo) {
        return pedidoService.realizarPedido(pedidomodelo);
    }
    @GetMapping("/query")
    public ArrayList<PedidoModel> obtenerPorEstatus(@RequestParam("estatus") String estatus) {
        return pedidoService.obtenerPorEstatus(estatus);
    }
    @GetMapping(path = "/{id}")
    public Optional<PedidoModel> obtenerPedidoPorId(@PathVariable ("id")Long id){
        return pedidoService.obtenerPorId(id);
    }
    @PutMapping(path = "{prodId}")
	public void putProducto(@PathVariable ("prodId") Long ProdId,
			@RequestParam(required=false)String estatus
			) {
    	pedidoService.actualizarProducto(ProdId, estatus);
	}
}