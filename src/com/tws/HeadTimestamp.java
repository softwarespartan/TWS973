package com.tws;

public class HeadTimestamp {

    public final int    reqId    ;
    public final String timestamp;

    public HeadTimestamp(int reqId, String timestamp) {
        this.reqId     = reqId    ;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return this.reqId + ": "+this.timestamp;
    }
}
