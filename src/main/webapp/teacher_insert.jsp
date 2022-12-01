<%--
  Created by IntelliJ IDEA.
  User: Level
  Date: 2022/11/30
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/StuGradeManagerSystem_war/teacher_insert" method="post">
            <h3>insert student</h3>
            <div>Student ID<input></div>
            <div>Course ID<input></div>

            <button type="submit"></button>
        </form>
    </div>
    <div>
        <form action="/StuGradeManagerSystem_war/teacher_insert" method="post">
            <h3>insert student's Grade</h3>
            <div>Student ID<input name="stu_id"></div>
            <div>Course ID<input name="course_id"></div>
            <div>Grade<input name="grade"></div>
            <button type="submit"></button>

        </form>
    </div>
</body>
</html>
