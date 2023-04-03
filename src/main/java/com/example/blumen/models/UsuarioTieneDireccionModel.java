package com.example.blumen.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_tienen_direcciones")
public class UsuarioTieneDireccionModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@OneToOne
	private UsuarioModel usuario;

	@OneToOne
	private DireccionModel direccion;

	public UsuarioTieneDireccionModel()
	{
	}

	public UsuarioTieneDireccionModel(Long id, UsuarioModel usuario, DireccionModel direccion)
	{
		this.id = id;
		this.usuario = usuario;
		this.direccion = direccion;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public UsuarioModel getUsuario()
	{
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario)
	{
		this.usuario = usuario;
	}

	public DireccionModel getDireccion()
	{
		return direccion;
	}

	public void setDireccion(DireccionModel direccion)
	{
		this.direccion = direccion;
	}
}