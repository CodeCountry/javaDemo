package com.example.demo;

public class Print implements InterfaceB {
    @Override
    public void printLowercaseLetter() {
        char[] chr=new char[26];
        char j=65;
        for(int i=0;i<=25;i++){
            chr[i]=j;
            j++;
        }
        System.out.print("大写字母：");
        for(char temp:chr){
            System.out.print(temp);
        }
        System.out.println();
    }

//    @Override
//    public void printCapitalLetter() {
//        char[] chr=new char[26];
//        char j=97;
//        for(int i=0;i<=25;i++){
//            chr[i]=j;
//            j++;
//        }
//        System.out.print("小写字母：");
//        for(char temp:chr){
//            System.out.print(temp);
//        }
//        System.out.println();
//    }
}