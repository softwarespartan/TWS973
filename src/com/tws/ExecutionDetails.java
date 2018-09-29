package com.tws;

import com.ib.client.Contract;
import com.ib.client.Execution;

public class ExecutionDetails {

    public final Contract  contract ;
    public final Execution execution;

    public ExecutionDetails(Contract contract, Execution execution) {
        this.contract = contract; this.execution = execution;
    }

    @Override
    public String toString(){
        return
                "orderId = "           + execution.orderId      ()+ "\n"
              + "clientId = "          + execution.clientId     ()+ "\n"
              + "conid = "             + contract.conid         ()+ "\n"
              + "symbol = "            + contract.symbol        ()+ "\n"
              + "secType = "           + contract.secType       ()+ "\n"
              + "expiry = "            + contract.lastTradeDateOrContractMonth        ()+ "\n"
              + "strike = "            + contract.strike        ()+ "\n"
              + "right = "             + contract.right         ()+ "\n"
              + "multiplier = "        + contract.multiplier    ()+ "\n"
              + "exchange = "          + contract.exchange      ()+ "\n"
              + "primaryExch = "       + contract.primaryExch   ()+ "\n"
              + "currency = "          + contract.currency      ()+ "\n"
              + "localSymbol = "       + contract.localSymbol   ()+ "\n"
              + "tradingClass = "      + contract.tradingClass  ()+ "\n"
              + "execId = "            + execution.execId       ()+ "\n"
              + "time = "              + execution.time         ()+ "\n"
              + "acctNumber = "        + execution.acctNumber   ()+ "\n"
              + "executionExchange = " + execution.exchange     ()+ "\n"
              + "side = "              + execution.side         ()+ "\n"
              + "shares = "            + execution.shares       ()+ "\n"
              + "price = "             + execution.price        ()+ "\n"
              + "permId = "            + execution.permId       ()+ "\n"
              + "liquidation = "       + execution.liquidation  ()+ "\n"
              + "cumQty = "            + execution.cumQty       ()+ "\n"
              + "avgPrice = "          + execution.avgPrice     ()+ "\n"
              + "orderRef = "          + execution.orderRef     ()+ "\n"
              + "evRule = "            + execution.evRule       ()+ "\n"
              + "evMultiplier = "      + execution.evMultiplier ()+ "\n";
    }
}
