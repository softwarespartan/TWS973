package com.tws;

import com.ib.client.Order;

public class OrderFactory {

    public static Order GenericLimitOrder(String account, String action, int quantity, double price){

        // init new order
        Order order = new Order();

        // set the order type to limit
        order.orderType("LMT");

        // set the account id
        order.account(account);

        // set the order type
        switch (action.toUpperCase()){
            case "BUY" : order.action("BUY") ; break;
            case "SELL": order.action("SELL"); break;
            default:
                System.out.println("invalid order action: "+action);
                order.action("");
        }

        // set the numer of shares
        order.totalQuantity(quantity);

        // set the limit price
        order.lmtPrice(price);

        // that's it ..
        return order;
    }

    public static Order GenericMarketOrder(String account, String action, int quantity){

        // init new order
        Order order = new Order();

        // set the order type to limit
        order.orderType("MKT");

        // set the account id
        order.account(account);

        // set the order type
        switch (action.toUpperCase()){
            case "BUY" : order.action("BUY"); break;
            case "SELL": order.action("SELL"); break;
            default:
                System.out.println("invalid order action: "+action);
                order.action("");
        }

        // set the number of shares
        order.totalQuantity(quantity);

        // that's it ..
        return order;
    }

    public static void main(String[] args){

        Order limitOrder  = OrderFactory.GenericLimitOrder ("DU207406", "BUY", 100, 200.2);
        Order marketOrder = OrderFactory.GenericMarketOrder("DU207406", "BUY", 100       );

        System.out.println(limitOrder.account()+" "+limitOrder.orderType()+" "+limitOrder.action()+" "+limitOrder.totalQuantity()+" "+limitOrder.lmtPrice());
    }
}
