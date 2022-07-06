package com.idat.Rest.controller;

import com.idat.Rest.model.Cliente;
import com.idat.Rest.service.ClienteService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes/v1")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<Cliente> listarCli(){
    
    	
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevoCli(@Validated @RequestBody Cliente cliente){
        service.nuevo(cliente);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarCli(@RequestBody Cliente cliente){
        Cliente cli = service.listarPorId(cliente.getIdCliente());
        if(cli != null){
            service.actualizar(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarId/{id_cliente}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Integer id_cliente){
        Cliente cli = service.listarPorId(id_cliente);
        if(cli != null){
            return new ResponseEntity<Cliente>(service.listarPorId(id_cliente),HttpStatus.OK);
        }
        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarCli(@Validated @RequestBody @PathVariable("id_cliente")Integer id_cliente) throws Exception{
        Cliente cli = service.listarPorId(id_cliente);
        if(cli == null){
            throw new Exception("No existe id");
        }
        service.eliminar(id_cliente);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
  
}
