package com.tws;

import com.ib.client.Contract;

/**
 * Associated with EWrapper:reqAccountUpdates
 */

public final class PortfolioUpdate {

    public final Contract contract     ;
    public final int      position     ;
    public final double   marketPrice  ;
    public final double   marketValue  ;
    public final double   averageCost  ;
    public final double   unrealizedPNL;
    public final double   realizedPNL  ;
    public final String   account      ;

    public PortfolioUpdate(
            Contract contract     ,
            double   position     ,
            double   marketPrice  ,
            double   marketValue  ,
            double   averageCost  ,
            double   unrealizedPNL,
            double   realizedPNL  ,
            String   account
    ){
        this.contract      =      contract     ;
        this.position      = (int)position     ;
        this.marketPrice   =      marketPrice  ;
        this.marketValue   =      marketValue  ;
        this.averageCost   =      averageCost  ;
        this.unrealizedPNL =      unrealizedPNL;
        this.realizedPNL   =      realizedPNL  ;
        this.account       =      account      ;
    }

    @Override
    public String toString(){
        return    this.account           + " "
                + this.contract.symbol() + " "
                + this.position          + " "
                + this.marketPrice       + " "
                + this.marketValue       + " "
                + this.averageCost       + " "
                + this.unrealizedPNL     + " "
                + this.realizedPNL;
    }
}
