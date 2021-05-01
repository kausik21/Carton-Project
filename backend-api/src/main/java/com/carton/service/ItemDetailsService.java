package com.carton.service;

import com.carton.model.ItemDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemDetailsService {

    List<ItemDetails> getAllItemDetails();

    ResponseEntity findItemDetailsById(Integer id);
}
