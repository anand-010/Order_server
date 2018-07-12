package com.android.order_ser.helperclassess;

/**
 * Created by anand on 6/30/2018.
 */

public class Order_projo {
    String names;
    String phoneno;

    public String getNames() {
        return names;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getPlacelist() {
        return placelist;
    }

    public String getItems() {
        return items;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrize() {
        return prize;
    }

    String placelist;

    public Order_projo() {
    }

    public Order_projo(String names, String phoneno, String placelist, String items, String quantity, String prize) {
        this.names = names;
        this.phoneno = phoneno;
        this.placelist = placelist;
        this.items = items;
        this.quantity = quantity;
        this.prize = prize;
    }

    String items;
    String quantity;
    String prize;
}
