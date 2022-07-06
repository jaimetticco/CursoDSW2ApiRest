package com.idat.Rest.service;


import com.idat.Rest.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listar();
    void nuevo(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Integer id_cliente);
    Cliente listarPorId(Integer id_cliente);

}
