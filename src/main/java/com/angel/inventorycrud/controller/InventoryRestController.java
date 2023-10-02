package com.angel.inventorycrud.controller;

import com.angel.inventorycrud.entity.Item;
import com.angel.inventorycrud.service.InventoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryRestController {

    //define the service implementation
    InventoryServiceImpl inventoryService;

    //inject the service implementation
    public InventoryRestController(InventoryServiceImpl inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> displayItemById(@PathVariable int id){
        Item dbItem =  inventoryService.find(id);
        if (dbItem!=null){
        return  new ResponseEntity<>(dbItem,HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/items")
    public ResponseEntity<List<Item>> displayItems(@RequestParam(name = "state",required = false) String state){
         List<Item> dbItems = inventoryService.findAll(state);
         if (dbItems.isEmpty()) return ResponseEntity.notFound().build();
         return new ResponseEntity<>(dbItems,HttpStatus.OK);

    }
    @PostMapping("/items")
    public ResponseEntity<Item> addItem(@RequestBody Item theItem){
            try {
                Item dbItem = inventoryService.save(theItem);
                if (dbItem == null) {
                    return new ResponseEntity<>(HttpStatus.CONFLICT);

                }
                return new ResponseEntity<>(dbItem, HttpStatus.CREATED);
            }
            catch (RuntimeException ex){
                return ResponseEntity.badRequest().build();
            }

    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Object> removeItem(@PathVariable int id){

       Item dbItem = inventoryService.find(id);
        if (dbItem==null){
            return   ResponseEntity.notFound().build();
        }
        inventoryService.remove(id);
        return ResponseEntity.noContent().build();
    }





}
