package com.idat.Rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.Rest.model.Productos;
import com.idat.Rest.service.ProductoService;

@Controller
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity <List<Productos>> listar() {
		return new ResponseEntity<List<Productos>>(service.listarP(), HttpStatus.OK);
		
	}
	
	@PostMapping("/guardar")	
	public ResponseEntity<Void> guardar(@RequestBody Productos productos) {
		service.guardarP(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/eliminar/{id}")	
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Productos p = service.obtenerPorId(id);
		
		if(p != null) {
			service.eliminarP(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PutMapping("/actualizar")	
	public ResponseEntity<Void> actualizar(@RequestBody Productos productos){
		
		Productos p = service.obtenerPorId(productos.getIdProducto());
		
		if(p != null) {
			service.actualizarP(productos);
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/listarPorId/{id}")	
	public ResponseEntity<Productos> obtenerPorId(@PathVariable Integer id){
		
		Productos p = service.obtenerPorId(id);
		
		if(p != null) {
			
			return new ResponseEntity<Productos>(service.obtenerPorId(id), HttpStatus.OK);
		
		}
		return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
}
