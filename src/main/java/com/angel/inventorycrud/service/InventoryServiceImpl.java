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
    public ResponseEntity<List<Item>> findAll(String state) {
        List<Item> results = inventoryDAO.findAll();
        if(state!=null){
            results=results.stream()
                    .filter(item -> Objects.equals(item.getLocation().getState(),state))
                    .collect(Collectors.toList());

        }
        if(results.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> find(int theId) {
        Optional<Item> result = inventoryDAO.findById(theId);

        return result.map(item -> {
            // Si se encuentra el Item, se devuelve una respuesta con código 200 (OK) y el Item.
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> {
            // Si no se encuentra el Item, se devuelve una respuesta con código 404 (Not Found).
            return ResponseEntity.notFound().build();
        });
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
