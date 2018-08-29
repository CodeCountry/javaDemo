package com.example.demo;

public class E {
    public static void main(String[] args){
        InterfaceA a =new Print();
        a.printCapitalLetter();
        InterfaceB b=new Print();
        b.printLowercaseLetter();

        InterfaceA e = new ClassA();
        InterfaceA ee = new ClassB();
        System.out.println("1到100的和是：" + e.method(100));
        System.out.println("10的阶乘是：" + ee.method(10));
    }
}
