package com.example.demo.controller;
import java.sql.*;

public class DBconnection {

    //    驱动类名
    String driver="com.mysql.jdbc.Driver";
    //    URL格式,最后为数据库名
    String url="jdbc:mysql://localhost:3306/study";    //JavaTest为你的数据库名称
    String user="root";
    String password="123456";
    Connection  coon=null;
    public DBconnection(){
        try{
//            加载驱动程序
            Class.forName(driver);
            coon=(Connection)DriverManager.getConnection(url,user,password);
            if(!coon.isClosed()){
                System.out.println("成功连接数据库！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        try{
            this.coon.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //    增加数据
    public void add(String name,int pwd){
//        String sql="insert into usrInfo(username,gender,age) values(?,?,?)";　　//向usrInfo表中插入数据
        String sql="insert into people(username,pwd) values('"+name+"','"+pwd+"')";
        try{
            PreparedStatement preStmt=(PreparedStatement)this.coon.prepareStatement(sql);
//            preStmt.setString(1, name);
//            preStmt.setInt(3, age);
//            preStmt.setString(2, gender);　　//和上面的注释的一块组成另外一种插入方法
            preStmt.executeUpdate();
            System.out.println("插入数据成功！");
            preStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //    查询
    public void select(){
        String sql="select * from people";                     //查询usrInfo表中的信息

        try{
            Statement stmt=(Statement)this.coon.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(sql);         //得到的是结果的集合
            System.out.println("--------------------------------");
            System.out.println("姓名"+"\t"+"密码");
            System.out.println("--------------------------------");
            while(rs.next()){
                String name=rs.getString("username");
                int pwd=rs.getInt("pwd");
                System.out.println(name+"\t"+pwd);
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    更改数据

    public void update(String name,int pwd){
        String sql="update people set pwd=? where username=?";        //推荐使用这种方式，下面的那种注释方式不知道为啥有时候不好使
//        String sql="update people set pwd="+pwd+" where username='"+name+"'";
        try{
            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
            prestmt.setInt(1, pwd);
            prestmt.setString(2,name);
            prestmt.executeUpdate();


//            Statement stmt=(Statement)this.coon.createStatement();
//            stmt.executeUpdate(sql);
            System.out.println("更改数据成功！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //    删除数据
    public void del(String name){
        String sql="delete from people where username=?";
        try{
            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
            prestmt.setString(1, name);
            prestmt.executeUpdate();
            System.out.println("删除数据成功！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
