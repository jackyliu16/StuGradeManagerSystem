<%--
  Created by IntelliJ IDEA.
  User: Level
  Date: 2022/11/30
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>hello <%= request.getParameter("id")%>} </h2>

        <form action="/StuGradeManagerSystem_war/teacher_inquery" method="post">
            <input type="submit" value="query student grade"></input>
        </form>
        <form action="/StuGradeManagerSystem_war/teacher_insert.jsp" method="post">
            <input type="submit" value="insert student grade"></input>
        </form>
        <form action="/StuGradeManagerSystem_war/teacher_updatepwd.jsp" method="post">
            <input type="submit" value="change the password"></input>
        </form>

</body>
</html>
