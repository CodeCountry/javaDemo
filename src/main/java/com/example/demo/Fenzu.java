package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fenzu {
    public static void main(String[] args){
        List<String> qiudui = new ArrayList<>();
        qiudui.add("科特迪瓦");
        qiudui.add("阿根廷");
        qiudui.add("澳大利亚");
        qiudui.add("塞尔维亚");
        qiudui.add("荷兰");
        qiudui.add("尼日利亚");
        qiudui.add("日本");
        qiudui.add("美国");
        qiudui.add("中国");
        qiudui.add("新西兰");
        qiudui.add("巴西");
        qiudui.add("比利时");
        qiudui.add("韩国");
        qiudui.add("喀麦隆");
        qiudui.add("洪都拉斯");
        qiudui.add("意大利");
        Random a = new Random();
        System.out.println(a.nextInt());
        System.out.println(qiudui.size());
    }
}
