<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: 长风
  Date: 2020/4/6
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="login.action" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td><input value="登陆" type="submit"></td>
            <td><a href="register.jsp"><input value="注册" type="button"></a></td>
        </tr>

    </table>
</form>

</body>

</html>
