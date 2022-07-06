package com.idat.Rest.service;

import java.util.List;

import com.idat.Rest.model.Productos;

public interface ProductoService {
	
	void guardarP(Productos productos);
	void actualizarP(Productos productos);
	void eliminarP(Integer id);
	List<Productos> listarP();
	Productos obtenerPorId(Integer id);

}
