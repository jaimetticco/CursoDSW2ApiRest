package com.idat.Rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public @ResponseBody List<Productos> listar() {
		return service.listarP();
		
	}
	
}
