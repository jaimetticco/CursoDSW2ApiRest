package com.idat.Rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.idat.Rest.model.Productos;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {
	
	@Autowired
	public List<Productos> listar = new ArrayList<>();
	

	@Override
	public void guardarP(Productos productos) {
		listar.add(productos);
	}

	@Override
	public void actualizarP(Productos productos) {
		Productos p = obtenerPorId(productos.getIdProducto());
		listar.remove(p);
		listar.add(productos);		
		
	}

	@Override
	public void eliminarP(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Productos> listarP() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Productos obtenerPorId(Integer id) {
		/*
		if(listar != null) {
			for(Productos productos : listar) {
				if(productos.getIdProducto() == id)
					return productos;
			}
		}
		
		return null;
		*/
		return listar.stream().filter(p -> p.getIdProducto()== id).findFirst().orElse(null);
	}

	
	

}
