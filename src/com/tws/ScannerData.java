package com.tws;

/**
 * Associated with EWrapper:scannerData
 */

public class ScannerData {

    public final int                           rank           ;
    public final com.ib.client.ContractDetails contractDetails;
    public final String                        distance       ;
    public final String                        benchmark      ;
    public final String                        projection     ;
    public final String                        legsStr        ;

    public ScannerData(
                       int                           rank           ,
                       com.ib.client.ContractDetails contractDetails,
                       String                        distance       ,
                       String                        benchmark      ,
                       String                        projection     ,
                       String                        legsStr
    ) {
        this.rank            = rank           ;
        this.contractDetails = contractDetails;
        this.distance        = distance       ;
        this.benchmark       = benchmark      ;
        this.projection      = projection     ;
        this.legsStr          = legsStr       ;
    }

    @Override
    public String toString(){
        return  " rank="         + this.rank                                      +
                " symbol="       + this.contractDetails.contract().symbol()       +
                " secType="      + this.contractDetails.contract().secType      ()+
                " expiry="       + this.contractDetails.contract().lastTradeDateOrContractMonth()       +
                " strike="       + this.contractDetails.contract().strike       ()+
                " right="        + this.contractDetails.contract().right        ()+
                " exchange="     + this.contractDetails.contract().exchange     ()+
                " currency="     + this.contractDetails.contract().currency     ()+
                " localSymbol="  + this.contractDetails.contract().localSymbol  ()+
                " marketName="   + this.contractDetails.marketName()              +
                " tradingClass=" + this.contractDetails.contract().tradingClass ()+
                " distance="     + this.distance                                  +
                " benchmark="    + this.benchmark                                 +
                " projection="   + this.projection                                +
                " legsStr="      + this.legsStr                                   ;
    }
}
