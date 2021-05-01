package com.carton.controller;

import com.carton.model.PriceDetails;
import com.carton.service.PriceCalculateService;
import com.carton.util.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("priceCalculator")
public class PriceCalculateController {
    private final PriceCalculateService priceCalculateService;

    @Autowired
    public PriceCalculateController(PriceCalculateService priceCalculateService) {
        this.priceCalculateService = priceCalculateService;
    }

    @PostMapping("/calculatePrice")
    public ResponseEntity getCalculatedPrice(@RequestBody PriceDetails priceDetails){
        return this.priceCalculateService.calculatePrice(priceDetails);
    }

    @GetMapping("/getUnitTypes")
    public UnitType[] geoUnitTypes() {
        return UnitType.values();
    }
}
