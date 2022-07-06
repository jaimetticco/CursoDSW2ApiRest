package com.idat.Rest.repository;

import com.idat.Rest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsRepository extends JpaRepository<Item, Integer> {
}
