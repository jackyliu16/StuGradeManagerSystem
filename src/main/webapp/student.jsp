<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/1
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/StuGradeManagerSystem_war/student_inquery" method="post">
      <input type="submit" value="search score">
    </form>
    <form action="/StuGradeManagerSystem_war/student_updatepwd.jsp" method="post">
        <input type="submit" value="change password">
    </form>
    <form action="/StuGradeManagerSystem_war/studentInfo" method="post">
        <input type="submit" value="View Info">
    </form>
    <form action="/StuGradeManagerSystem_war/student_inqueryclass" method="post">
        <input type="submit" value="View Class">
    </form>
</body>
</html>
