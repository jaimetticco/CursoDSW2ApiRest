package com.idat.Rest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.Rest.model.Cliente;
import com.idat.Rest.repository.IClientesRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private IClientesRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        repository.saveAndFlush(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_cliente) {
        repository.deleteById(id_cliente);
    }

    @Override
    @Transactional
    public Cliente listarPorId(Integer id_cliente) {
        return repository.findById(id_cliente).orElse(null);
    }
}
