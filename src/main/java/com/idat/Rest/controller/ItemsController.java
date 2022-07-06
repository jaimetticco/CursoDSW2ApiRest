package com.idat.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.idat.Rest.model.Item;
import com.idat.Rest.service.ItemsService;

import java.util.List;


@RestController
@RequestMapping(value = "/items/v1")
public class ItemsController {

    @Autowired
    private ItemsService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<Item> listarItem(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevoItem(@Validated @RequestBody Item item){
        service.nuevo(item);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarItem(@RequestBody Item item){
        Item i = service.listarPorId(item.getIdItem());
        if(i != null){
            service.actualizar(item);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarItem(@Validated @RequestBody @PathVariable("id_item")Integer id_item) throws Exception{
        Item i = service.listarPorId(id_item);
        if(i == null){
            throw new Exception("No existe id");
        }
        service.eliminar(id_item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
