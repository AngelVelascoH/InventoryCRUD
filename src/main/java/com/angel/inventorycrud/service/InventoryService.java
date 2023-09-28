package com.angel.inventorycrud.service;

import com.angel.inventorycrud.entity.Item;

import java.util.List;

public interface InventoryService {
    List<Item> findAll();
    Item find(int theId);
    Item save(Item theItem);
    void remove(int theId);


}
