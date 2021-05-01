package com.carton.service;

import com.carton.model.PriceDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface PriceCalculateService {

    ResponseEntity calculatePrice(PriceDetails priceDetails);
}
