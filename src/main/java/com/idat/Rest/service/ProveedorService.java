package com.idat.Rest.service;





import java.util.List;

import com.idat.Rest.model.Proveedor;

public interface ProveedorService {

    List<Proveedor> listar();
    void nuevo(Proveedor proveedor);
    void actualizar(Proveedor proveedor);
    void eliminar(Integer id_proveedor);
    Proveedor listarPorId(Integer id_proveedor);
}
