package com.company.entity;

import java.io.Serializable;

public enum Preciousness implements Serializable {
    PRECIOUS("Precious"), SEMIPRECIOUS("SemiPrecious");
    private String value;
    public String getValue(){
        return value;
    }
    Preciousness(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
