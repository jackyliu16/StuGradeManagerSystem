<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/1
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="/StuGradeManagerSystem_war/student_updatepwd" method="post">
<div>
    Old password<input name="Oldpassword">
</div>
<div>
    New password<input name="Newpassword">
</div>
<input type="submit" value="submit">
</form>
</body>
</html>
