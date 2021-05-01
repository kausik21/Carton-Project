package com.carton.serviceImpl;

import com.carton.model.ItemDetails;
import com.carton.repository.ItemDetailsRepository;
import com.carton.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDetailsServiceImpl implements ItemDetailsService {
    private final ItemDetailsRepository itemDetailsRepository;

    @Autowired
    public ItemDetailsServiceImpl(ItemDetailsRepository itemDetailsRepository) {
        this.itemDetailsRepository = itemDetailsRepository;
    }


    @Override
    public List<ItemDetails> getAllItemDetails() {
        return itemDetailsRepository.findAll();
    }

    @Override
    public ResponseEntity findItemDetailsById(Integer id) {
        Optional<ItemDetails> itemDetails = itemDetailsRepository.findById(id);
        if(itemDetails.isPresent()){
           return new ResponseEntity<>(itemDetailsRepository.findById(id).get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Items Found", HttpStatus.BAD_REQUEST);
        }
    }
}
