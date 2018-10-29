package com.example.demo.fullDemo.util;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {

    Connection conn=null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public Connection getConnection(){

        //    驱动类名
        String driver="com.mysql.jdbc.Driver";
        //    URL格式,最后为数据库名
        String url="jdbc:mysql://localhost:3306/user-table";    //JavaTest为你的数据库名称
        String user="root";
        String password="123456";

        try{
            // 加载驱动程序
            Class.forName(driver);
            // 建立数据库连接
//            conn=(java.sql.Connection)DriverManager.getConnection(url,user,password);
            conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed()){
                System.out.println("成功连接数据库！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return conn;


    }


    // 释放资源
    public void closeAll() {
        // 如果rs不空，关闭rs
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 如果pstmt不空，关闭pstmt
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 如果conn不空，关闭conn
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行SQL语句，可以进行查询
     */
    public ResultSet executeQuery(String preparedSql, Object[] param) {
        // 处理SQL,执行SQL
        try {
            // 得到PreparedStatement对象
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // 为预编译sql设置参数
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            // 执行SQL语句
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // 处理SQLException异常
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public int executeUpdate(String preparedSql, Object[] param) {

        int num = 0;
        // 处理SQL,执行SQL
        try {
            this.getConnection();
            // 得到PreparedStatement对象
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // 为预编译sql设置参数
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            // 执行SQL语句
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            // 处理SQLException异常
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return num;
    }
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        System.out.println(dbUtil.getConnection());
    }




}

