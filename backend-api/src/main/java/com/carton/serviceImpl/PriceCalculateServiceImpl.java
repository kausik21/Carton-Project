package com.carton.serviceImpl;

import com.carton.model.ItemDetails;
import com.carton.model.PriceDetails;
import com.carton.repository.ItemDetailsRepository;
import com.carton.service.PriceCalculateService;
import com.carton.util.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceCalculateServiceImpl implements PriceCalculateService {

    private final ItemDetailsRepository itemDetailsRepository;

    @Autowired
    public PriceCalculateServiceImpl(ItemDetailsRepository itemDetailsRepository) {
        this.itemDetailsRepository = itemDetailsRepository;
    }

    @Override
    public ResponseEntity calculatePrice(PriceDetails priceDetails) {
        Optional<ItemDetails> itemDetails = this.itemDetailsRepository.findById(priceDetails.getItemDetailsSeq());
        if(itemDetails.isPresent()){
            if(priceDetails.getUnitType().equals(UnitType.CARTON.getUnitType())){
                double price = itemDetails.get().getCartonPrice() * priceDetails.getUnitCount();
                if(priceDetails.getUnitCount()>=itemDetails.get().getCartonCountForDiscount()){
                    Double finalPrice = price - (itemDetails.get().getCartonPrice() * itemDetails.get().getCartonDiscountPercentage());
                    priceDetails.setDiscountInPrice((itemDetails.get().getCartonPrice() * itemDetails.get().getCartonDiscountPercentage()));
                    priceDetails.setFinalPrice(finalPrice);
                }else{
                    priceDetails.setFinalPrice(price);
                }
                priceDetails.setPrice(price);
            }else{
                int singleUnitCount = priceDetails.getUnitCount() % itemDetails.get().getNoOfUnitsInCarton();
                int cartonCount = priceDetails.getUnitCount() / itemDetails.get().getNoOfUnitsInCarton();
                double price = itemDetails.get().getCartonPrice() * cartonCount;
                double finalPrice = price;
                double singleUnitPrice = (itemDetails.get().getCartonPrice() * itemDetails.get().getSingleUnitPricePercentage()) / itemDetails.get().getNoOfUnitsInCarton();
                if(cartonCount > 0){
                    if(cartonCount >= itemDetails.get().getCartonCountForDiscount()){
                        finalPrice = price - (itemDetails.get().getCartonPrice() * itemDetails.get().getCartonDiscountPercentage());
                        priceDetails.setDiscountInPrice((itemDetails.get().getCartonPrice() * itemDetails.get().getCartonDiscountPercentage()));
                    }
                }
                if(singleUnitCount > 0){
                    finalPrice = finalPrice + (singleUnitPrice * singleUnitCount);
                }
                priceDetails.setFinalPrice(finalPrice);
            }
            return new ResponseEntity<>(priceDetails, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Items Found", HttpStatus.BAD_REQUEST);
        }
    }
}
