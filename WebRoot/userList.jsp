<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="com.example.demo.fullDemo.pojos.Page" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示页面</title>
    <style type="text/css">

        body {
            text-align: center;
        }
        .numberPage {
            border: 1px solid #000;
            padding: 1px 7px;
            text-decoration: none;
        }
        table {
            width: 75%;
            border-collapse: collapse;
        }
        table tr:nth-child(odd) {
            background: #ccc;
        }
    </style>

</head>
<body>
<!-- 查询模块 -->
<form action="${pageContext.request.contextPath}/UserAction" method="post">
    用户名：<input type="text" name="usersName" />
    <input type="hidden" value="readUser" name="method">
    <input type="submit" value="查询">
</form>
${users}
<br />
<!-- 表格模块 -->
<table border="1" align="center">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>更新</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${userList.pageRow}" var="user">
        <tr>
            <td>${user.id }</td>
            <td>${user.userName }</td>
            <td>${user.userPwd }</td>
            <td>${user.sex==0?'女':'男' }</td>
            <td>${user.age }</td>
            <td><a href="addUser.jsp">更新</a></td>
            <td><a href="${pageContext.request.contextPath}/UserAction?method=${user.id }">删除</a></td>
        </tr>
    </c:forEach>
</table>
<br />
<!-- 分页模块=>注意：判断是否头（begin）溢出和尾（end）溢出 -->
<c:out value="第${userList.pageNow}页/共${userList.pageCount}页"></c:out>
<c:if test="${userList.pageNow > 1}">
    <a href="<c:url value="UserAction?method=userList&pageNow=${1}" />" class="numberPage">首页</a>
    <a href="<c:url value="UserAction?method=userList&pageNow=${userList.pageNow-1}" />" class="numberPage">上一页</a>
</c:if>
<!--
		总页数小于要显示的页数（5页）
			begin（起始页码） = 1；
			end（末尾页码） = ${userList.pageCount}；
		总页数大于要显示的页数（5页）
			begin = ${userList.pageNow - 2 }；
			end = ${userList.pageNow - 2 }；
	 -->
<c:choose>
    <c:when test="${userList.pageCount < userList.pageSize }">
        <c:set var="begin" value="1" />
        <c:set var="end" value="${userList.pageCount}" />
    </c:when>
    <c:otherwise>
        <c:set var="begin" value="${userList.pageNow - 2 }" />
        <c:set var="end" value="${userList.pageNow + 2 }" />
        <c:if test="${begin < 1 }">
            <c:set var="begin" value="${1}" />
            <c:set var="end" value="${5}" />
        </c:if>
        <c:if test="${end > userList.pageCount }">
            <c:set var="begin" value="${userList.pageCount-4}" />
            <c:set var="end" value="${userList.pageCount}" />
        </c:if>
    </c:otherwise>
</c:choose>
<%-- 循环打印页码（i），如果${i eq userList.pageNow }则取消超链接 --%>
<c:forEach var="i" begin="${begin }" end="${end }">
    <c:choose>
        <c:when test="${i eq userList.pageNow }">
            ${i}
        </c:when>
        <c:otherwise>
            <a href="<c:url value="UserAction?method=userList&pageNow=${i}" />" class="numberPage">${i}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${userList.pageNow < userList.pageCount}">
    <a href="<c:url value="UserAction?method=userList&pageNow=${userList.pageNow+1}" />" class="numberPage">下一页</a>
    <a href="<c:url value="UserAction?method=userList&pageNow=${userList.pageCount}" />" class="numberPage">尾页</a>
</c:if>
</body>
</html>