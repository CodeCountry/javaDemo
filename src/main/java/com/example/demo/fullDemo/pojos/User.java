package com.example.demo.fullDemo.pojos;

public class User {

    // id,userName,userPwd,sex,age
    private int id;
    private String userName;
    private String userPwd;
    private String userRePwd;
    private String sex;
    private int age;

    public User() {
        super();
    }

    public User(String userName, String userPwd, String userRePwd, String sex, int age) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRePwd = userRePwd;
        this.sex = sex;
        this.age = age;
    }

    public User(int id, String userName, String userPwd, String userRePwd, String sex, int age) {
        super();
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRePwd = userRePwd;
        this.sex = sex;
        this.age = age;
    }

    public User(int id, String userName, String userPwd, String sex, int age) {
        super();
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserRePwd() {
        return userRePwd;
    }

    public void setUserRePwd(String userRePwd) {
        this.userRePwd = userRePwd;
    }

    /**
     * 重写toString方法
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("用户Id：" + id + "； ");
        sb.append("用户名：" + userName + "； ");
        sb.append("密码：" + userPwd + "； ");
        sb.append("性别：" + (sex.equals("1")?'男':'女') + "； ");
        sb.append("年龄：" + age + "； ");
        sb.append("<a href=\"${pageContext.request.contextPath}/UserAction?method=userList\">隐藏</a>");
        return sb.toString();
    }


}
