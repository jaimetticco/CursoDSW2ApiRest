package com.idat.Rest.repository;


import com.idat.Rest.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientesRepository extends JpaRepository<Cliente, Integer> {
}
