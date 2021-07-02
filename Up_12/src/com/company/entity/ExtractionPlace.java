package com.company.entity;

import java.io.Serializable;

public enum ExtractionPlace implements Serializable {
    EUROPE("Europe"), AFRICA("Africa"), NORTH_AMERICA("North-America"), SOUTH_AMERICA("South-America"), ASIA("Asia"), SIBERIA("Siberia");
    private String value;
    ExtractionPlace(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
