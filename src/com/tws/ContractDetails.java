package com.tws;

import com.ib.client.TagValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Associated with EWrapper:reqContractDetails
 */

public class ContractDetails {

    public final int                           reqId          ;
    public final com.ib.client.ContractDetails contractDetails;

    public ContractDetails(int reqId, com.ib.client.ContractDetails contractDetails) {
        this.reqId           = reqId          ;
        this.contractDetails = contractDetails;
    }

    @Override
    public String toString() {
        String msg = "conid = "           + this.contractDetails.contract().conid        ()+ "\n"
                   + "symbol = "          + this.contractDetails.contract().symbol       ()+ "\n"
                   + "secType = "         + this.contractDetails.contract().secType      ()+ "\n"
                   + "expiry = "          + this.contractDetails.contract().lastTradeDateOrContractMonth       ()+ "\n"
                   + "strike = "          + this.contractDetails.contract().strike       ()+ "\n"
                   + "right = "           + this.contractDetails.contract().right        ()+ "\n"
                   + "multiplier = "      + this.contractDetails.contract().multiplier   ()+ "\n"
                   + "exchange = "        + this.contractDetails.contract().exchange     ()+ "\n"
                   + "primaryExch = "     + this.contractDetails.contract().primaryExch  ()+ "\n"
                   + "currency = "        + this.contractDetails.contract().currency     ()+ "\n"
                   + "localSymbol = "     + this.contractDetails.contract().localSymbol  ()+ "\n"
                   + "tradingClass = "    + this.contractDetails.contract().tradingClass ()+ "\n"
                   + "marketName = "      + this.contractDetails.marketName             ()+ "\n"
                   + "minTick = "         + this.contractDetails.minTick                ()+ "\n"
                   + "price magnifier = " + this.contractDetails.priceMagnifier         ()+ "\n"
                   + "orderTypes = "      + this.contractDetails.orderTypes             ()+ "\n"
                   + "validExchanges = "  + this.contractDetails.validExchanges         ()+ "\n"
                   + "underConId = "      + this.contractDetails.contract().conid       ()+ "\n"
                   + "longName = "        + this.contractDetails.longName               ()+ "\n"
                   + "contractMonth = "   + this.contractDetails.contractMonth          ()+ "\n"
                   + "industry = "        + this.contractDetails.industry               ()+ "\n"
                   + "category = "        + this.contractDetails.category               ()+ "\n"
                   + "subcategory = "     + this.contractDetails.subcategory            ()+ "\n"
                   + "timeZoneId = "      + this.contractDetails.timeZoneId             ()+ "\n"
                   + "tradingHours = "    + this.contractDetails.tradingHours           ()+ "\n"
                   + "liquidHours = "     + this.contractDetails.liquidHours            ()+ "\n"
                   + "evRule = "          + this.contractDetails.evRule                 ()+ "\n"
                   + "evMultiplier = "    + this.contractDetails.evMultiplier           ()+ "\n";

        String sec = "secIdList={";
        if (contractDetails.secIdList() != null) {
            List<TagValue> secIdList = contractDetails.secIdList();
            for (int i = 0; i < secIdList.size(); ++i) {
                TagValue param = secIdList.get(i);
                if (i > 0) { sec += ","; }
                sec += param.m_tag + "=" + param.m_value;
            }
        }

        return msg+sec+"}\n";
    }
}
