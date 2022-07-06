package com.idat.Rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.idat.Rest.model.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer>{

	
	
}
