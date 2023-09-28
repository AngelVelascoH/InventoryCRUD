package com.angel.inventorycrud.DAO;

import com.angel.inventorycrud.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDAO extends JpaRepository<Item,Integer> {
    //repositorio de Spring Data JPA.
}
