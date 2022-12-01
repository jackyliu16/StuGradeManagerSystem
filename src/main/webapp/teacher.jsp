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
    <div>
        <form action="/StuGradeManagerSystem_war/teacher_inquery.jsp" method="post">
            <button type="submit" value="query student grade"></button>
        </form>
        <form action="/StuGradeManagerSystem_war/teacher_insert.jsp" method="post">
            <button type="submit" value="insert student grade"></button>
        </form>
        <form >
            <button type="submit" value="manage personal information"></button>
        </form>
    </div>
</body>
</html>
