package com.example.Catalog_Service.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Catalog_Service.Model.BakeryItem;
import com.example.Catalog_Service.Repository.BakeryItemRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BakeryItemServiceImpl implements BakeryItemService{

    private BakeryItemRepository bakeryItemRepository;

    @Override
    public List<BakeryItem> getBakeryItems() {
        return bakeryItemRepository.findAll();
    }

    @Override
    public BakeryItem getBakeryItem(int id) {
        return bakeryItemRepository.findById(id).orElse(null);
    }

    @Override
    public void addBakeryItem(BakeryItem bakeryItem) {
        bakeryItemRepository.save(bakeryItem);
    }

    @Override
    public void removeBakeryItem(int id) {
        bakeryItemRepository.deleteById(id);
    }

    @Override
    public void updateBakeryItem(int id, Map<String,Object> updates) {
        BakeryItem item = getBakeryItem(id);
        if (updates.containsKey("name")) {
            item.setName((String)updates.get("name"));
        }
        if (updates.containsKey("price")) {
            item.setPrice((Double)updates.get("price"));
        }
        bakeryItemRepository.save(item);
    }

}
