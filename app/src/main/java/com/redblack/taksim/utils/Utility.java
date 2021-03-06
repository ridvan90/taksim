package com.redblack.taksim.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Utility {

    private static SimpleDateFormat sdf;
    private static String currentDateandTime;

    public static boolean isValidEmail(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    public static boolean isValidMobile(Integer phone_length) {

        if(phone_length == 0 || phone_length < 10){

            return false;
        }else{
            return true;
        }
    }

    public static String taksimetre(String km){

        km = km.replace("km",""); //replace km to ""
        km = km.trim();//trim space

        double start_price = 3.90;
        double last_price = 0.0;
        double per_km = 3.70;
        double get_km = Double.parseDouble(km);

        last_price = start_price + (per_km * get_km);
        return (new DecimalFormat("##.##").format(last_price) + " " + "TL"); //With Decimal fotmat, showing only two digit after decimal
    }

    public static String GetDateandTime(){
        //get date and Time
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateandTime = sdf.format(new Date());
        return  currentDateandTime;
    }


}
