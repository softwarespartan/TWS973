package com.tws;

public final class TickByTickMidPoint {

    public final int    reqId   ;
    public final double time    ;
    public final double midPoint;

    public TickByTickMidPoint(int reqId, double time, double midPoint) {
        this.reqId = reqId; this.time = time; this.midPoint = midPoint;
    }

    @Override
    public String toString(){ return this.reqId +", "+this.time+", "+this.midPoint; }
}
