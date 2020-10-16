package com.tws;

import com.ib.client.TickAttr;

public final class TickByTickAllLast {
    public final int      reqId            ;
    public final int      tickType         ;
    public final double   time             ;
    public final double   price            ;
    public final int      size             ;
    public final TickAttr attribs          ;
    public final String   exchange         ;
    public final String   specialConditions;

    public TickByTickAllLast(
            int      reqId   ,
            int      tickType,
            double   time    ,
            double   price   ,
            int      size    ,
            TickAttr attribs ,
            String   exchange,
            String   specialConditions
    ) {
        this.reqId             = reqId            ;
        this.tickType          = tickType         ;
        this.time              = time             ;
        this.price             = price            ;
        this.size              = size             ;
        this.attribs           = attribs          ;
        this.exchange          = exchange         ;
        this.specialConditions = specialConditions;
    }

    @Override
    public String toString(){
        return  this.reqId    +", "+
                this.tickType +", "+
                this.time     +", "+
                this.price    +", "+
                this.size     +", "+
                this.exchange +", "+
                this.specialConditions;
    }
}
