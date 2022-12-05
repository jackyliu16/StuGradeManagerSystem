<%--
  Created by IntelliJ IDEA.
  User: Level
  Date: 2022/12/5
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h2>hello <%= request.getParameter("id")%> </h2>
      <form action="/StuGradeManagerSystem_war/admin_inquery" method="post">
            <div>
                  <span>view the </span>
                  <input type="text" name="type" placeholder="请选择查询类型" autocomplete="off" list="list" required>
                  <datalist id="list">
                        <option>student</option>
                        <option>teacher</option>
                        <option>grade</option>
                        <option>class</option>
                  </datalist>
                  <span>list </span>
            </div>
            <input type="submit" value="inquiry"/>
      </form>







      <form action="/StuGradeManagerSystem_war/admin_update" method="post">



            <input type="submit" value="manage the information"/>
      </form>








      <form action="/StuGradeManagerSystem_war/admin_register" method="post">
            <div>
                  <span>ID：</span><input name="id" placeholder="please enter id">
            </div>
            <div>
                  <span>Name：</span><input name="name" placeholder="please enter the name">
            </div>
            <div>
                  <span>DeptNo/MajorNo：</span><input name="No" placeholder="please enter the DeptNo or MajorNo">
            </div>
            <div>
                  <span>password：</span><input name="pwd" placeholder="please enter password">
            </div>
            <div>
                  <span>password：</span><input placeholder="please enter password again">
            </div>
            <div>
                  <span>what is the status:</span>
                  <input type="text" name="status" placeholder="请选择查询类型" autocomplete="off" list="list3" required>
                  <datalist id="list3">
                        <option>student</option>
                        <option>teacher</option>
                  </datalist>
                  <input type="submit" value="create new user "/>
            </div>
      </form>













      <form action="/StuGradeManagerSystem_war/admin_delete" method="post">
            <div>
                  <span>Student ID：</span><input name="stu_id" placeholder="please enter id">
            </div>
            <div>
                  <span>Exclass ID：</span><input name="exclass_id" placeholder="please enter the Exclass ID">
            </div>
            <input type="submit" value="delete the information"/>
      </form>
</body>
</html>
