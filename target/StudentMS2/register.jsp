<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 长风
  Date: 2020/4/6
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="register.action">
<table>
    <tr>
        <td>学号</td>
        <td><input type="text" name="num"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="pass"></td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>性别</td>
        <td>
            <input type="radio" name="sex" value="男">男
            <input type="radio" name="sex" value="女">女
        </td>
    </tr>
    <tr>
        <td>生日</td>
        <td><input type="text" name="bir"></td>
    </tr>
    <tr>
        <td>大学</td>
        <td><input type="text" name="un"></td>
    </tr>
    <tr>
        <td>年级</td>
        <td><input type="text" name="grade"></td>
    </tr>
    <tr>
        <td>院系</td>
        <td><input type="text" name="dep"></td>

    </tr>
    <tr>
        <td>专业</td>
        <td><input type="text" name="major"></td>

    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="注册"></td>
    </tr>
</table>

</form>
</body>
</html>
