package com.example.Catalog_Service.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Catalog_Service.Model.BakeryItem;
import com.example.Catalog_Service.Service.BakeryItemService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
public class BakeryItemController {

    private BakeryItemService bakeryItemService;

    @GetMapping("/")
    public List<BakeryItem> getBakeryItems() {
        return bakeryItemService.getBakeryItems();
    }
    
    @GetMapping("/{id}")
    public BakeryItem getBakeryItem(@PathVariable int id) {
        return bakeryItemService.getBakeryItem(id);
    }
    
    @PostMapping("/add")
    public void addBakeryItem(@RequestBody BakeryItem entity) {
        bakeryItemService.addBakeryItem(entity);
    }
    
    @DeleteMapping("/remove/{id}")
    public void removeBakeryItem(@PathVariable int id){
        bakeryItemService.removeBakeryItem(id);
    }

    @PatchMapping("/update/{id}")
    public void updateBakeryItem(@PathVariable int id,@RequestBody Map<String, Object> updates) {
        bakeryItemService.updateBakeryItem(id, updates);
    }
}
