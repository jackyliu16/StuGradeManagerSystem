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
            <h3>insert student into the Exclass</h3>
            <div>Student ID<input name="stu_id"></div>
            <div>Course ID<input name="stu_id"></div>

            <input type="submit"/>
        </form>
    </div>
    <div>
        <form action="/StuGradeManagerSystem_war/teacher_updateGrade" method="post">
            <h3>update student's Grade</h3>
            <div>Student ID<input name="stu_id"></div>
            <div>Course ID<input name="course_id"></div>
            <div>Grade<input name="grade"></div>
            <input type="submit"/>

        </form>
    </div>
</body>
</html>
