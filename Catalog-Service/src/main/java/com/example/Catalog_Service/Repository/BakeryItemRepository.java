package com.example.Catalog_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Catalog_Service.Model.BakeryItem;

@Repository
public interface BakeryItemRepository extends JpaRepository<BakeryItem,Integer>{

}
