package com.example.demo;

public class Testcompute {
    public static void main(String[] args){
        UseCompute uc = new UseCompute();
        System.out.print("10+5=");
        uc.useCom(new Jia(),10,5);
        System.out.print("10-5=");
        uc.useCom(new Jian(),10,5);
        System.out.print("10/0=");
        uc.useCom(new Chu(),10,0);
    }
}
