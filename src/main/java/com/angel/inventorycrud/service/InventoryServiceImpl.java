package com.angel.inventorycrud.service;

import com.angel.inventorycrud.DAO.InventoryDAO;
import com.angel.inventorycrud.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryDAO inventoryDAO;

    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public List<Item> findAll(String state) {
        List<Item> results = inventoryDAO.findAll();
        if(state!=null){
            results=results.stream()
                    .filter(item -> Objects.equals(item.getLocation().getState(),state))
                    .collect(Collectors.toList());

        }

        return results;
    }

    @Override
    public Item find(int theId) {
        Optional<Item> result = inventoryDAO.findById(theId);
        return result.orElse(null);

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
