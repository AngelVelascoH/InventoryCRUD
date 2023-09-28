package com.angel.inventorycrud.controller;

import com.angel.inventorycrud.entity.Item;
import com.angel.inventorycrud.service.InventoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        ResponseEntity<Item> dbItem = inventoryService.find(id);
        return dbItem;
    }


    @GetMapping("/items")
    public ResponseEntity<List<Item>> displayItems(@RequestParam(name = "state",required = false) String state){
         return inventoryService.findAll(state);

    }
    @PostMapping("/items")
    public Item addItem(@RequestBody Item theItem){
        Item dbItem = inventoryService.save(theItem);
        return dbItem;
    }

    @DeleteMapping("/items/{id}")
    public void removeItem(@PathVariable int id){
        inventoryService.remove(id);
    }





}
