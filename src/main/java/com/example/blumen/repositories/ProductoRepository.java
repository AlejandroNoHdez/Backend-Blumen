package com.example.blumen.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blumen.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{

    public ArrayList<ProductoModel> findByNombreRamo(String nombreRamo);

}