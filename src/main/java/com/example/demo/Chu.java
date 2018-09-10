package com.example.demo;

public class Chu implements Compute{
    @Override
    public int computer(int n, int m){
        int sum = 0;
        try{
            sum =n/m;
        }catch(Exception e){
            System.out.println("被除数不能为0");
        }
        return sum;
    }
}
