package com.idat.Rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Rest.model.Productos;
import com.idat.Rest.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	

	@Override
	public void guardarP(Productos productos) {
		// TODO Auto-generated method stub
		repository.save(productos);

	}

	@Override
	public void actualizarP(Productos productos) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(productos);

	}

	@Override
	public void eliminarP(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<Productos> listarP() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Productos obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
