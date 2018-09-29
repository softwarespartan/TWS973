package com.tws;

import com.ib.client.Contract;

public class ContractFactory {

    public static Contract GenericContract     (String symbol){

        // init an empty contract
        Contract contract = new Contract();

        // set the symbol for the contract
        contract.symbol(symbol);

        // fill in the contract with default values
        contract.conid(0 )        ;
        contract.secType("")      ;
        contract.lastTradeDateOrContractMonth("");
        contract.strike(0.0 );
        contract.right("");
        contract.multiplier("");
        contract.exchange("SMART");
        contract.primaryExch("ISLAND");
        contract.currency("USD" );
        contract.localSymbol("");
        contract.tradingClass ("");
        contract.secIdType ("" );
        contract.secId(null);
        //contract.underComp(null);
        contract.comboLegsDescrip(null);
        contract.comboLegs(null);
        contract.includeExpired(false);

        // that's all folks
        return contract;
    }

    public static Contract GenericStockContract(String symbol){

        // init an empty contract
        Contract contract = ContractFactory.GenericContract(symbol);

        // set the security type to stock
        //contract.secType(Types.SecType.STK.toString());

        // that's a [w]rap
        return contract;
    }


}
