package com.carton.controller;

import com.carton.model.ItemDetails;
import com.carton.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemDetailsController {

    private final ItemDetailsService itemDetailsService;

    @Autowired
    public ItemDetailsController(ItemDetailsService itemDetailsService) {
        this.itemDetailsService = itemDetailsService;
    }

    @GetMapping
    public List<ItemDetails> getAllItemDetails() {
       return this.itemDetailsService.getAllItemDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity getItemDetailsById(@PathVariable("id") Integer id){
        return this.itemDetailsService.findItemDetailsById(id);
    }

}
