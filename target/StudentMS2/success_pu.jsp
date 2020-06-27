<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 长风
  Date: 2020/4/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<h3>基于Struts2+Hibernate的学生信息管理系统</h3>
<h4>当前登陆：<s:property value="#session.adminType"/> <s:property value="#session.adminUsername"/></h4>


<form method="post" action="findStudent.action">
    <table>
        <tr>
            <td>根据姓名查询:</td>
            <td><input type="text" name="find"></td>
            <td><input type="submit" value="查询"></td>
        </tr>
    </table>
</form>

<form method="post" action="findDep.action">
    <table>
        <tr><td>
            <s:select name="findDep" label="选择学院查询" headerValue="----------请选择----------" headerKey="1"
                      list="{'信电','艺术','体育','物理','农院'}">
            </s:select>
        </td>
            <td align="center">
                <input type="submit" value="查询">
            </td></tr>

    </table>
</form>

<br><br>
<table border="2">
    <tr>
        <td>序号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>生日</td>
        <td>学校</td>
        <td>学院</td>
        <td>专业</td>
        <td>年级</td>
    </tr>
    <s:iterator value="#session.stuList" status="st">
        <tr>
            <td><s:property value="#st.count"/> </td>
            <td><s:property value="studentID"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="password"/></td>
            <td><s:property value="sex"/></td>
            <td><s:property value="birthday"/></td>
            <td><s:property value="university"/></td>
            <td><s:property value="department"/></td>
            <td><s:property value="major"/></td>
            <td><s:property value="grade"/></td>
        </tr>
    </s:iterator>
</table>


</body>
</html>
