package com.example.demo.fullDemo.service;

import com.example.demo.fullDemo.dao.UserDao;
import com.example.demo.fullDemo.pojos.User;
import com.example.demo.fullDemo.pojos.Page;

public class UserService {

    UserDao userDao = null;

    public UserService() {
        super();
        this.userDao = new UserDao();
    }

    // 业务逻辑
    public boolean addUser(User user) {
        // 判断用户的年龄是否大于16周岁
        // 判断一下用户的密码是否包含特殊字符（汉子）
        // 判断用户的密码和确认密码相同
        // return userDao.save(user)>0;
        int result = userDao.save(user);
        if (result > 0) {
            return true;
        }
        return false;
    }

    public User readUser(String userName) {
        return userDao.readUser(userName);
    }

    public boolean updateUser(User user) {
        int result = userDao.updateUser(user);
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        int result = userDao.deleteUser(id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    public Page<User> queryPage(Integer pageSize, Integer pageNow) {
        return userDao.queryPage(pageSize, pageNow);
    }


}
