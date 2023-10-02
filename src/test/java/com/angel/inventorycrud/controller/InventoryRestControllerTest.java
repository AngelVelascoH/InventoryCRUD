package com.angel.inventorycrud.controller;
import com.angel.inventorycrud.DAO.InventoryDAO;
import com.angel.inventorycrud.entity.Item;
import com.angel.inventorycrud.entity.Location;
import com.angel.inventorycrud.service.InventoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class InventoryRestControllerTest {
    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Mock
    private InventoryDAO inventoryDAO;

    @Test
    public void testFindMethodSuccess() {
        when(inventoryDAO.findById(1)).thenReturn(Optional.of(new Item(1,"Laptop","Laptopt Dell",new Location(1,"Edomex","cto 8 jose de san martin",5515266354L))));
        Item item = inventoryService.find(1);
        Assertions.assertEquals("Laptop",item.getItemName());
    }
    @Test
    public void testFindMethodFailNotFound() {
        when(inventoryDAO.findById(1)).thenReturn(Optional.of(new Item(1,"Laptop","Laptopt Dell",new Location(1,"Edomex","cto 8 jose de san martin",5515266354L))));
        Item item = inventoryService.find(2);
        Assertions.assertNull(item);
    }

    @Test
    public void testFindAllMethodSuccess() {
        List<Item> itemList = Arrays.asList(
                new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L)),
                new Item(2,"Monitor","Monitor Samsung",new Location(2,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L))
        );

        // Llamar al método findAll() del repositorio.
        when(inventoryDAO.findAll()).thenReturn(itemList);
        List<Item> items = inventoryService.findAll(null);
        // Verificar que se recuperaron los elementos esperados.
        Assertions.assertEquals(2, items.size());
    }


    @Test
    public void testFindAllMethodFilteredByStateSuccess() {
        List<Item> itemList = Arrays.asList(
                new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L)),
                new Item(2,"Monitor","Monitor Samsung",new Location(2,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L)),
                new Item(2,"Teclado","Teclado Razer",new Location(3,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L))
        );

        // Llamar al método findAll() del repositorio.
        when(inventoryDAO.findAll()).thenReturn(itemList);
        List<Item> items = inventoryService.findAll("CDMX");
        // Verificar que se recuperaron los elementos esperados.
        Assertions.assertEquals(2, items.size());
    }
    @Test
    public void testFindAllMethodFilteredByStateFail() {
        List<Item> itemList = Arrays.asList(
                new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L)),
                new Item(2,"Monitor","Monitor Samsung",new Location(2,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L)),
                new Item(2,"Teclado","Teclado Razer",new Location(3,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L))
        );

        // Llamar al método findAll() del repositorio.
        when(inventoryDAO.findAll()).thenReturn(itemList);
        List<Item> items = inventoryService.findAll("Puebla");
        // Verificar que se recuperaron los elementos esperados.
        Assertions.assertTrue(items.isEmpty());
    }

    @Test
    public void testSaveMethodSuccess(){
        Item item = new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L));

    when(inventoryDAO.save(item)).thenReturn(item);

    Item savedItem = inventoryService.save(item);

    Assertions.assertNotNull(savedItem);
    Assertions.assertEquals(item, savedItem);
    }

    @Test
    public void testSaveMethodFailConflict(){
        List<Item> itemList = Arrays.asList(
                new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L)),
                new Item(2,"Monitor","Monitor Samsung",new Location(2,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L)),
                new Item(2,"Teclado","Teclado Razer",new Location(3,"CDMX","Blvd Adolfo Lopez Mateo Las Aguilas",5525667182L))
        );

    when(inventoryDAO.findAll()).thenReturn(itemList);
    Item item = new Item(1,"Laptop","Laptop Dell",new Location(1,"Edomex","Cto 8 Jose de San Martin",5515266354L));
    Item savedItem = inventoryService.save(item);
    Assertions.assertNull(savedItem);
    }



}