package com.carton.model;

public class PriceDetails {
    private Integer priceDetailsSeq;
    private Integer itemDetailsSeq;
    private Integer unitType;
    private Integer unitCount;
    private Double price;
    private Double discount;
    private Double finalPrice;
    private Double discountInPrice;

    public Integer getPriceDetailsSeq() {
        return priceDetailsSeq;
    }

    public void setPriceDetailsSeq(Integer priceDetailsSeq) {
        this.priceDetailsSeq = priceDetailsSeq;
    }

    public Integer getItemDetailsSeq() {
        return itemDetailsSeq;
    }

    public void setItemDetailsSeq(Integer itemDetailsSeq) {
        this.itemDetailsSeq = itemDetailsSeq;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getDiscountInPrice() {
        return discountInPrice;
    }

    public void setDiscountInPrice(Double discountInPrice) {
        this.discountInPrice = discountInPrice;
    }

}
