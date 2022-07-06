package com.idat.Rest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.idat.Rest.model.Proveedor;
import com.idat.Rest.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping(value = "/proveedor/v1")
public class ProveedorController {

    @Autowired
    private ProveedorService service;


    @GetMapping("/listar")
    public @ResponseBody
    List<Proveedor> listarProv(){
    	Proveedor p = new Proveedor();
    	
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevoProv(@Validated @RequestBody Proveedor proveedor){
        service.nuevo(proveedor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarProv(@RequestBody Proveedor proveedor){
        Proveedor prov = service.listarPorId(proveedor.getIdProveedor());
        if(prov != null){
            service.actualizar(proveedor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarProv(@Validated @RequestBody @PathVariable("id_proveedor")Integer id_proveedor) throws Exception{
        Proveedor prov = service.listarPorId(id_proveedor);
        if(prov == null){
            throw new Exception("No existe id");
        }
        service.eliminar(id_proveedor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    }
