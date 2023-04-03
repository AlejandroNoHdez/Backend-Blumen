package com.example.blumen.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blumen.models.DireccionModel;

@Repository
public interface DireccionRepository extends CrudRepository<DireccionModel, Long>{
    
	@Query("SELECT d FROM DireccionModel d WHERE d.codigo_postal = ?1")
	public ArrayList<DireccionModel> findByCodigoPostal(String codigoPostal);

}