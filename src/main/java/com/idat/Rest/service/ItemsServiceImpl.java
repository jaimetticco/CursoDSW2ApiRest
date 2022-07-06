package com.idat.Rest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.Rest.model.Item;
import com.idat.Rest.repository.IItemsRepository;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private IItemsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Item> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Item item) {
        repository.save(item);
    }

    @Override
    @Transactional
    public void actualizar(Item item) {
        repository.saveAndFlush(item);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_item) {
        repository.deleteById(id_item);
    }

    @Override
    @Transactional(readOnly = true)
    public Item listarPorId(Integer id_item) {
        return repository.findById(id_item).orElse(null);
    }
}
