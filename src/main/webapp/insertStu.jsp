<%--
  Created by IntelliJ IDEA.
  User: 长风
  Date: 2020/4/9
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<form method="post" action="insertStu.action">
    <table>
        <tr>
            <td>学号</td>
            <td><input type="text" name="student.studentID"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="student.password"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="student.name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="student.sex" value="男">男
                <input type="radio" name="student.sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="student.birthday"></td>
        </tr>
        <tr>
            <td>大学</td>
            <td><input type="text" name="student.university"></td>
        </tr>
        <tr>
            <td>年级</td>
            <td><input type="text" name="student.grade"></td>
        </tr>
        <tr>
            <td>院系</td>
            <td><input type="text" name="student.department"></td>

        </tr>
        <tr>
            <td>专业</td>
            <td><input type="text" name="student.major"></td>

        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>

</form>
</body>
</html>
