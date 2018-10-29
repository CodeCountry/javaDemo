package com.example.demo.fullDemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.fullDemo.pojos.User;
import com.example.demo.fullDemo.pojos.Page;
import com.example.demo.fullDemo.util.DBUtil;

public class UserDao {

    DBUtil dbUtil = null;

    public UserDao() {
        super();
        dbUtil = new DBUtil();
    }
    /**
     * 添加方法
     * @param user
     * @return
     */
    public int save(User user) {
        // id,userName,userPwd,sex,age
        String sql = "insert into t_User(userName,userPwd,sex,age) values(?,?,?,?)";
        Object[] param = { user.getUserName(), user.getUserPwd(), user.getSex(), user.getAge() };
        dbUtil.getConnection();
        int result = dbUtil.executeUpdate(sql, param);
        dbUtil.closeAll();
        return result;
    }

    /**
     * 查询方法
     *
     * @param userName
     * @return User对象
     */
    public User readUser(String userName) {
        User user = null;
        String sql = "select * from t_user where userName=?";
        Object[] param = { userName };
        dbUtil.getConnection();
        ResultSet rs = dbUtil.executeQuery(sql, param);
        try {
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("userName"), rs.getString("userPwd"), rs.getString("sex"),
                        rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return user;
    }

    /**
     * 修改方法
     *
     * @param user
     * @return result
     */
    public int updateUser(User user) {
        // id,userName,userPwd,sex,age
        String sql = "update t_user set userPwd=?,sex=?,age=? where userName=?";
        Object[] param = { user.getUserPwd(), user.getSex(), user.getAge(), user.getUserName() };
        dbUtil.getConnection();
        int result = dbUtil.executeUpdate(sql, param);
        dbUtil.closeAll();
        return result;
    }

    /**
     * 删除方法
     *
     * @param id
     *            userId
     * @return result
     */
    public int deleteUser(Integer id) {
        String sql = "delete from t_user where id=?";
        Object[] param = { id };
        dbUtil.getConnection();
        int result = dbUtil.executeUpdate(sql, param);
        dbUtil.closeAll();
        return result;
    }

    /**
     * 分页方法
     * @param pageSize 每一页的行数
     * @param pageNow 当前页
     * @return page
     */
    public Page<User> queryPage(int pageSize, int pageNow) {
        Page<User> page = new Page<User>();
        page.setPageSize(pageSize);
        page.setPageNow(pageNow);
        String sql = "select count(*) from t_user";
        dbUtil.getConnection();
        ResultSet rs = dbUtil.executeQuery(sql, null);
        try {
            rs.next();
            Integer rowCount = rs.getInt(1);
            page.setRowCount(rowCount);
            List<User> pageRow = new ArrayList<User>();
            String preparedSql = "select * from t_user limit ?,?";
            Object[] param = { page.getPageSize() *( page.getPageNow() - 1), page.getPageSize() };
            ResultSet res = dbUtil.executeQuery(preparedSql, param);
            while (res.next()) {
                User user = new User(res.getInt("id"), res.getString("userName"), res.getString("userPwd"),
                        res.getString("sex"), res.getInt("age"));
                pageRow.add(user);
            }
            page.setpageRow(pageRow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return page;
    }


}
