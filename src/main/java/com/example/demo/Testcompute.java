package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Testcompute {
    public static void main(String[] args){
        UseCompute uc = new UseCompute();
        System.out.print("10+5=");
        uc.useCom(new Jia(),10,5);
        System.out.print("10-5=");
        uc.useCom(new Jian(),10,5);
        System.out.print("10/0=");
        uc.useCom(new Chu(),10,0);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        String inday = dateFormat.format(new Date());
//        System.out.println(inday);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date date = calendar.getTime();
        System.out.println(sdf.format(date));

    }
}
