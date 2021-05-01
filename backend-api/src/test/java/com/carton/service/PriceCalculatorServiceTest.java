package com.carton.service;

import com.carton.model.ItemDetails;
import com.carton.model.PriceDetails;
import com.carton.repository.ItemDetailsRepository;
import com.carton.util.UnitType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceCalculatorServiceTest {

    @MockBean
    private PriceCalculateService priceCalculateService;

    @MockBean
    private ItemDetailsRepository itemDetailsRepository;

    @Test
    public void calculatePriceOfSingleUnits(){
        ItemDetails itemDetails = getItemDetails();
        if(itemDetails != null){
            PriceDetails priceDetails = new PriceDetails();
            priceDetails.setUnitType(UnitType.SINGLE_UNIT.getUnitType());
            priceDetails.setItemDetailsSeq(itemDetails.getItemDetailsSeq());
            priceDetails.setUnitCount(10);
            PriceDetails priceDetails1 = (PriceDetails) priceCalculateService.calculatePrice(priceDetails).getBody();
            if (priceDetails1 != null) {
                assertThat(priceDetails1.getFinalPrice()).isEqualTo(113.75);
            }
        }
    }

    @Test
    public void calculatePriceOfCartonUnits(){
        ItemDetails itemDetails = getItemDetails();
        if(itemDetails != null){
            PriceDetails priceDetails = new PriceDetails();
            priceDetails.setUnitType(UnitType.CARTON.getUnitType());
            priceDetails.setItemDetailsSeq(itemDetails.getItemDetailsSeq());
            priceDetails.setUnitCount(4);
            PriceDetails priceDetails1 = (PriceDetails) priceCalculateService.calculatePrice(priceDetails).getBody();
            if (priceDetails1 != null) {
                assertThat(priceDetails1.getFinalPrice()).isEqualTo(682.5);
            }
        }
    }

    private ItemDetails getItemDetails() {
        Optional<ItemDetails> itemDetails = this.itemDetailsRepository.findById(1);
        return itemDetails.orElse(null);
    }

}
