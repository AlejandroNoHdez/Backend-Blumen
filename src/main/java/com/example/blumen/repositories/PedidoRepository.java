package com.example.blumen.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blumen.models.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{
    public ArrayList<PedidoModel> findByEstatus (String estatus);
}