package com.tws;

public class FundamentalData {

    public final int   reqId;
    public final String data;


    public FundamentalData(int reqId, String data) {
        this.reqId = reqId;
        this.data  = data ;
    }

    @Override
    public String toString(){
        return this.reqId +": " +this.data;
    }
}
