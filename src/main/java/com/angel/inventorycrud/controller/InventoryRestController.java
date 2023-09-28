package com.angel.inventorycrud.controller;

import com.angel.inventorycrud.entity.Item;
import com.angel.inventorycrud.service.InventoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryRestController {

    //define the service implementation
    InventoryServiceImpl inventoryService;

    //inject the service implementation
    public InventoryRestController(InventoryServiceImpl inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/items")
    public String displayItems(){
        return "Im working fine";
    }
    @PostMapping("/items")
    public Item addItem(@RequestBody Item theItem){
        Item dbItem = inventoryService.save(theItem);
        return dbItem;
    }





}
