package com.idat.Rest.service;





import java.util.List;

import com.idat.Rest.model.Item;

public interface ItemsService {

    List<Item> listar();
    void nuevo(Item item);
    void actualizar(Item item);
    void eliminar(Integer id_item);
    Item listarPorId(Integer id_item);
}
