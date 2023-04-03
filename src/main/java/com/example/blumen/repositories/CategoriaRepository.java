package com.example.blumen.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blumen.models.CategoriaModel;


@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Long>{
    
    public ArrayList<CategoriaModel> findByNombre (String nombre);

}
