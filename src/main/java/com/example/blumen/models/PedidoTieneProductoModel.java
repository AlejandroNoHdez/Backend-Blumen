package com.example.blumen.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="pedidos_tienen_productos")
public class PedidoTieneProductoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @OneToOne
    private UsuarioModel usuario;
    
    @OneToOne
    private ProductoModel producto;
    
    @OneToOne
    private PedidoModel pedido;

	public PedidoTieneProductoModel() {
		
	}

	public PedidoTieneProductoModel(Long id, UsuarioModel usuario, ProductoModel producto, PedidoModel pedido) {
		this.id = id;
		this.usuario = usuario;
		this.producto = producto;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}
	
	
}