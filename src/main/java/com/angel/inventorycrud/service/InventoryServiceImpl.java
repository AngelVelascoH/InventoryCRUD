package com.angel.inventorycrud.service;

import com.angel.inventorycrud.DAO.InventoryDAO;
import com.angel.inventorycrud.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryDAO inventoryDAO;

    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public List<Item> findAll() {
        return inventoryDAO.findAll();
    }

    @Override
    public Item find(int theId) {

        Optional<Item> result = inventoryDAO.findById(theId);
        //check if the Item is present in the Optional.
        result.ifPresentOrElse(item ->
        {
            //there is an Item
        },()->
        {
            //theres no Item with that Id
            throw new RuntimeException("There is no Item with the given Id: "+ theId);
        });
        return result.get();
    }

    @Override
    public Item save(Item theItem) {
        return inventoryDAO.save(theItem);
    }

    @Override
    public void remove(int theId) {
    inventoryDAO.deleteById(theId);
    }
}
