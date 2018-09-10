package com.example.demo;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorldCup {
    public static void main(String[] args){
        // Map集合
        Map<Integer,String> wcup = new HashMap<>();
        wcup.put(1930, "乌拉圭");
        wcup.put(1934, "意大利");
        wcup.put(1938, "意大利");
        wcup.put(1950, "乌拉圭");
        wcup.put(1954, "西德");
        wcup.put(1958, "巴西");
        wcup.put(1962, "巴西");
        wcup.put(1966, "英格兰");
        wcup.put(1970, "巴西");
        wcup.put(1974, "西德");
        wcup.put(1978, "阿根廷");
        wcup.put(1982, "意大利");
        wcup.put(1986, "阿根廷");
        wcup.put(1990, "西德");
        wcup.put(1994, "巴西");
        wcup.put(1998, "法国");
        wcup.put(2002, "巴西");
        wcup.put(2006, "意大利");
        wcup.put(2010, "西班牙");
        wcup.put(2014, "德国");

        System.out.println("请输入一个年份：");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();       // 获取输入的内容
        if(wcup.containsKey(key)){           // 如果集合中包含输入的内容
            System.out.println(key+"年获得世界杯冠军的国家是："+wcup.get(key));
        }else{
            System.out.println("该年没有举办世界杯！");
        }

        System.out.println("请输入国家名称：");
        Scanner scc = new Scanner(System.in);
        String val = scc.nextLine();
        if(wcup.containsValue(val)){          // 如果集合中包含输入的国家
            for(Integer year:wcup.keySet()){
                if(wcup.get(year).equals(val)){
                    System.out.println(year+"\t");
                }
            }
        }else{
            System.out.println("该国家没有获得过世界杯冠军!");
        }


    }
}
