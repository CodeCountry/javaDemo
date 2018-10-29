package com.example.demo.fullDemo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.fullDemo.pojos.User;
import com.example.demo.fullDemo.pojos.Page;
import com.example.demo.fullDemo.service.UserService;

public class UserAction extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public UserAction() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("addUser".equals(method)) {
            addUser(request, response);
        } else if ("userList".equals(method)) {
            showUserList(request, response);
        } else if ("readUser".equals(method)) {
            readUser(request, response);
        } else {
            deleteUser(request, response, method);
        }
    }

    /**
     * 分页显示模块
     */
    private void showUserList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        // List<User> userList = userService.getAllUserInfo();
        String pageNow = request.getParameter("pageNow");
        if (pageNow == null||pageNow.isEmpty()) {//如果当前页为空或者首次使用则pageNow=1
            Page<User> userList = userService.queryPage(5, 1);
            request.setAttribute("userList", userList);
        }else {
            Page<User> userList = userService.queryPage(5, Integer.parseInt(pageNow));
            request.setAttribute("userList", userList);
        }
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }


    /**
     * 添加和修改用户模块
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userRePwd = request.getParameter("userRePwd");
        String ageStr = request.getParameter("age");
        String sex = request.getParameter("sex");
        if(userName==null||userPwd==null||!userPwd.equals(userRePwd)||ageStr==null||sex==null) {
            request.getSession().setAttribute("message", "更新失败，请重新填写！");
            response.sendRedirect(request.getContextPath()+"/addUser.jsp");
        }else {
            User user = new User(userName, userPwd, userRePwd, sex, Integer.parseInt(ageStr));
            UserService userService = new UserService();
            User users = userService.readUser(userName);
            if (users != null) {//判断用户（users）是否存在，若存在使用修改方法，若不存在则添加。
                userService.updateUser(user);
            } else {
                userService.addUser(user);
            }
            showUserList(request, response);
        }
    }

    /**
     * 查询用户模块，哦，与上一模块有冗余
     */
    private void readUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        String userName = request.getParameter("usersName");
        User users = userService.readUser(userName);
        if (users != null)
            request.setAttribute("users", users.toString());
        showUserList(request, response);
    }

    /**
     * 删除用户模块
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response, String method)
            throws ServletException, IOException {
        UserService userService = new UserService();
        Integer id = Integer.parseInt(method);
        userService.deleteUser(id);
        showUserList(request, response);
    }



}
