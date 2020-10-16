package com.tws;

import com.ib.client.TickAttr;

public final class TickByTickBidAsk {

    public final int      reqId   ;
    public final double   time    ;
    public final double   bidPrice;
    public final double   askPrice;
    public final int      bidSize ;
    public final int      askSize ;
    public final TickAttr attribs ;

    public TickByTickBidAsk(
            int      reqId   ,
            double   time    ,
            double   bidPrice,
            double   askPrice,
            int      bidSize ,
            int      askSize ,
            TickAttr attribs
    ) {
        this.reqId    = reqId   ;
        this.time     = time    ;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.bidSize  = bidSize ;
        this.askSize  = askSize ;
        this.attribs  = attribs ;
    }

    @Override
    public String toString(){
        return  this.reqId      +", "+
                this.time       +", "+
                this.bidPrice   +", "+
                this.askPrice   +", "+
                this.bidSize    +", "+
                this.askSize;
    }
}
