package com.example.demo;

public class ClassA implements InterfaceA {
    @Override
    public int method (int n){
        int sum = 0;
        for(int i=0;i<=n;i++){
            sum += i;
        }
        return sum;
    }
    @Override
    public void printCapitalLetter() {

    }
}
