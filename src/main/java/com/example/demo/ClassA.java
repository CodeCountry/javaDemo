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
        char[] chr=new char[26];
        char j=97;
        for(int i=0;i<=25;i++){
            chr[i]=j;
            j++;
        }
        System.out.print("小写字母：");
        for(char temp:chr){
            System.out.print(temp);
        }
        System.out.println();
    }
}
