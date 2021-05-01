package com.carton.model;

import javax.persistence.*;

@Entity
@Table(name = "item_details")
public class ItemDetails {
    private Integer itemDetailsSeq;
    private String itemName;
    private Double cartonPrice;
    private Integer noOfUnitsInCarton;
    private Double singleUnitPricePercentage;
    private Integer cartonCountForDiscount;
    private Double cartonDiscountPercentage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getItemDetailsSeq() {
        return itemDetailsSeq;
    }

    public void setItemDetailsSeq(Integer itemDetailsSeq) {
        this.itemDetailsSeq = itemDetailsSeq;
    }

    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(name = "carton_price")
    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    @Column(name = "carton_units")
    public Integer getNoOfUnitsInCarton() {
        return noOfUnitsInCarton;
    }

    public void setNoOfUnitsInCarton(Integer noOfUnitsInCarton) {
        this.noOfUnitsInCarton = noOfUnitsInCarton;
    }

    @Column(name = "single_unit_price_percentage")
    public Double getSingleUnitPricePercentage() {
        return singleUnitPricePercentage;
    }

    public void setSingleUnitPricePercentage(Double singleUnitPricePercentage) {
        this.singleUnitPricePercentage = singleUnitPricePercentage;
    }

    @Column(name = "discount_carton_count")
    public Integer getCartonCountForDiscount() {
        return cartonCountForDiscount;
    }

    public void setCartonCountForDiscount(Integer cartonCountForDiscount) {
        this.cartonCountForDiscount = cartonCountForDiscount;
    }

    @Column(name = "carton_discount_percentage")
    public Double getCartonDiscountPercentage() {
        return cartonDiscountPercentage;
    }

    public void setCartonDiscountPercentage(Double cartonDiscountPercentage) {
        this.cartonDiscountPercentage = cartonDiscountPercentage;
    }
}
