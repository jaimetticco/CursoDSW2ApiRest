package com.idat.Rest.repository;

import java.util.List;

import com.idat.Rest.model.Productos;

public interface ProductoRepository {

	void guardarP(Productos productos);
	void actualizarP(Productos productos);
	void eliminarP(Integer id);
	List<Productos> listarP();
	Productos obtenerPorId(Integer id);
	
}
