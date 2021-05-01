package com.carton.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UnitType {

    CARTON(1, "CARTON"),
    SINGLE_UNIT(2, "SINGLE_UNIT");

    private Integer unitType;
    private String unitTypeDescription;

    UnitType(Integer unitType, String unitTypeDescription) {
        this.unitType = unitType;
        this.unitTypeDescription = unitTypeDescription;
    }

    public static UnitType findOne(Integer unitType) {
        return Arrays.stream(UnitType.values())
                .filter(x -> x.unitType.equals(unitType))
                .findFirst()
                .orElse(null);
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public String getUnitTypeDescription() {
        return unitTypeDescription;
    }

    public void setUnitTypeDescription(String unitTypeDescription) {
        this.unitTypeDescription = unitTypeDescription;
    }
}
