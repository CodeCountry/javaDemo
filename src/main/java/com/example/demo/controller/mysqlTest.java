package com.example.demo.controller;
import java.util.Scanner;
import java.sql.*;

public class mysqlTest {

    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        DBconnection db=new DBconnection();

//        插入数据
//        System.out.println("输入姓名，密码：");
//        String name=in.next();
//        int pwd=in.nextInt();
//        db.add(name, pwd);


//        修改数据
        String name=in.next();
        int pwd=in.nextInt();
        db.update(name, pwd);


//        删除数据
//        String name=in.next();
//        db.del(name);


//        查询数据
        db.select();

//        db.close();





    }


}
