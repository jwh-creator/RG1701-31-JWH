<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 长风
  Date: 2020/4/14
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<h3>个人信息管理</h3>
<table >
    <s:iterator value="#session.stuList" status="st">
        <tr>
            <td>学号</td>
            <td><input type="text" name="studentID" value="<s:property value="studentID"/>"> </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="<s:property value="name"/>"> </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="<s:property value="password"/>"> </td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex" value="<s:property value="sex"/>"> </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="<s:property value="birthday"/>"> </td>
        </tr>
        <tr>
            <td>学校</td>
            <td><input type="text" name="university" value="<s:property value="university"/>"> </td>
        </tr>

        <tr>
            <td>年级</td>
            <td><input type="text" name="grade" value="<s:property value="grade"/>"> </td>
        </tr>

        <tr>
            <td>学院</td>
            <td><input type="text" name="department" value="<s:property value="department"/>"> </td>
        </tr>
        <tr>
            <td>专业</td>
            <td><input type="text" name="major" value="<s:property value="major"/>"> </td>
        </tr>
        <tr>

            <td><a href="updateMess.jsp?name=<s:property value="name"/> "> 修改</a></td>
        </tr>

    </s:iterator>
</table>
</body>
</html>
