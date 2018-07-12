package com.android.order_ser.helperclassess;

/**
 * Created by anand on 6/26/2018.
 */

public class Orderdatagenerator {
    public String name;
    public String prize;
    public String lastupdated;
    public Orderdatagenerator(){}
    public Orderdatagenerator(String name, String prize, String lastupdated) {
        this.name = name;
        this.prize = prize;
        this.lastupdated = lastupdated;
    }

    public String getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }

    public String getLastupdated() {
        return lastupdated;
    }


}
