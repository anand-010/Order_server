package com.android.order_ser.helperclassess;

/**
 * Created by anand on 6/13/2018.
 */

public class userdatas {
    static String name;
    static  String email;
    static  String phoneno;

    public static void setname(String name) {
        userdatas.name = name;
    }

    public static void setEmail(String email) {
        userdatas.email = email;
    }

    public static void setPhoneno(String phoneno) {
        userdatas.phoneno = phoneno;
    }

    public static void setPlace(String place) {
        userdatas.place = place;
    }

    static  String place;

    public static String getname() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhoneno() {
        return phoneno;
    }

    public static String getPlace() {
        return place;
    }
}
