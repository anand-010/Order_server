package com.android.order_ser.helperclassess;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anand on 6/13/2018.
 */

public class userdatas {
    static FirebaseAuth auth = FirebaseAuth.getInstance();
    static String name;
    static  String email;
    static  String phoneno;
    static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();
    public static DatabaseReference rootref(){
        return databaseReference;
    }
    public static void setname(String name) {
        userdatas.name = name;

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
        return auth.getCurrentUser().getEmail().toString();
    }
    public static String getuid() {
        return auth.getCurrentUser().getUid();
    }
    public static String getPhoneno() {
        return phoneno;
    }

    public static String getPlace() {
        return place;
    }
}
