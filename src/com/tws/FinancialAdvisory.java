package com.tws;

public class FinancialAdvisory {

    public final int    faDataType;
    public final String data      ;


    public FinancialAdvisory(int faDataType, String data) {
        this.faDataType = faDataType;
        this.data       = data      ;
    }

    @Override
    public String toString(){
        return this.faDataType+": "+this.data;
    }
}
