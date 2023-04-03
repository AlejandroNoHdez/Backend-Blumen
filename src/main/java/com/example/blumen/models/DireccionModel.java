package com.example.blumen.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="direcciones")
public class DireccionModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;
    @Column(nullable=false)
    private String calle;
    private String num_interior;
    @Column(nullable=false)
    private String num_exterior;
    @Column(nullable=false)
    private String codigo_postal;
    private String referencia;
    
    @OneToOne(mappedBy = "direccion")
    private UsuarioTieneDireccionModel utdm;
    
	public DireccionModel() {
	}

	public DireccionModel(Long id, String calle, String num_interior, String num_exterior, String codigo_postal,
			String referencia) {
		super();
		this.id = id;
		this.calle = calle;
		this.num_interior = num_interior;
		this.num_exterior = num_exterior;
		this.codigo_postal = codigo_postal;
		this.referencia = referencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNum_interior() {
		return num_interior;
	}

	public void setNum_interior(String num_interior) {
		this.num_interior = num_interior;
	}

	public String getNum_exterior() {
		return num_exterior;
	}

	public void setNum_exterior(String num_exterior) {
		this.num_exterior = num_exterior;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}