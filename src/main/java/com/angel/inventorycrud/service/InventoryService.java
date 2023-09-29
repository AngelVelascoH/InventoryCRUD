package com.angel.inventorycrud.service;

import com.angel.inventorycrud.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InventoryService {
    List<Item> findAll(String state);
    Item find(int theId);
    Item save(Item theItem);
    void remove(int theId);


}
