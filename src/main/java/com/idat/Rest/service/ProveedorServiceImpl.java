package com.idat.Rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.Rest.model.Proveedor;
import com.idat.Rest.repository.IProveedorRepository;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private IProveedorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Proveedor proveedor) {
        repository.save(proveedor);
    }

    @Override
    @Transactional
    public void actualizar(Proveedor proveedor) {
        repository.saveAndFlush(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_proveedor) {
        repository.deleteById(id_proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor listarPorId(Integer id_proveedor) {
        return repository.findById(id_proveedor).orElse(null);
    }
}
