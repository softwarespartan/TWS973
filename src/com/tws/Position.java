package com.tws;

import com.ib.client.Contract;

/**
 * Associated with EWrapper:reqPositions
 */

public final class Position {

    public final String   account    ;
    public final Contract contract   ;
    public final int      position   ;
    public final double   averageCost;

    public Position(String account, Contract contract, double position, double averageCost){
        this.account = account; this.contract = contract; this.position = (int)position; this.averageCost = averageCost;
    }

    @Override
    public String toString(){
        return this.contract.symbol()+" "+this.position+" "+this.averageCost;
    }
}
