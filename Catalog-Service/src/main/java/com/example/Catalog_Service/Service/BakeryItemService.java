package com.example.Catalog_Service.Service;

import java.util.List;
import java.util.Map;

import com.example.Catalog_Service.Model.BakeryItem;

public interface BakeryItemService {
    public List<BakeryItem> getBakeryItems();

    public BakeryItem getBakeryItem(int id);

    public void addBakeryItem(BakeryItem bakeryItem);

    public void removeBakeryItem(int id);

    public void updateBakeryItem(int id,Map<String,Object> updates);
}
