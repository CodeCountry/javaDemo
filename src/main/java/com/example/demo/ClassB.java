package com.example.demo;

public class ClassB implements InterfaceA {
    @Override
    public int method (int n){
        int sum = 1;
        for(int i =1; i<=n;i++){
            sum*=n;
        }
        return sum;
    }
    @Override
    public void printCapitalLetter(){

    }
}
