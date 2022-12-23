<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link type = "text/css" rel = "stylesheet" href = "css/font.css"/>


<!--basic_css-->
<link rel="stylesheet" href="css/xadmin.css" type = "text/css">
<link rel="stylesheet" href="layui/css/layui.css" media="all" type = "text/css">
<!--basic_js-->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<head>
    <style type="text/css">
        a:link {
            text-decoration: none;
            color: black;
        }
        .layui-input{
            width: 50%;
        }
    </style>

    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>


<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="#">Hello! Admin</a><a href="#"></a></div>
    <div class="left_open">
        <i title="Expand the left column" class="iconfont">&#9668;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">Admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="login.jsp">Exit</a></dd>
            </dl>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <form action="/StuGradeManagerSystem_war/admin.jsp" method="post" name="form7">
                    <a href="javascript:document.form7.submit();">
                        <cite>Main Page</cite>
                    </a>
                </form>
            <li>
            <li>
                <a href="javascript:;">
                    <cite>Admin Action</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_inquery.jsp" method="post" name="form1">
                            <a href="javascript:document.form1.submit();">
                                <cite>Inquery</cite>
                            </a>
                        </form>
                    </li >
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_registerstudent.jsp" method="post" name="form2">
                            <a href="javascript:document.form2.submit();">
                                <cite>Student Register</cite>
                            </a>
                        </form>
                    </li >
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_registerteacher.jsp" method="post" name="form3">
                            <a href="javascript:document.form3.submit();">
                                <cite>Teacher Register</cite>
                            </a>
                        </form>
                    </li>
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_deletestudentclass.jsp" method="post" name="form4">
                            <a href="javascript:document.form4.submit();">
                                <cite>Delete Student from Exclass</cite>
                            </a>
                        </form>
                    </li>
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_deleteteaching.jsp" method="post" name="form5">
                            <a href="javascript:document.form5.submit();">
                                <cite>Delete Teaching Relationship</cite>
                            </a>
                        </form>
                    </li>
                    <li>
                        <form action="/StuGradeManagerSystem_war/admin_updatemajor.jsp" method="post" name="form6">
                            <a href="javascript:document.form6.submit();">
                                <cite>Update Student Major</cite>
                            </a>
                        </form>
                    </li>


                </ul>
            </li>



        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->

<div class="page-content">
    <div class="container">
        <div class="layui-fluid" style="font-max-size: xxx-large">
            <blockquote class="layui-elem-quote">
                <marquee onmouseover="this.stop()" onmouseout="this.start()" behavior="alternate">
                    <font class="text">Welcome to SCNU Student Management System !</font>
                </marquee>
            </blockquote>
        </div>
        <div class="layui-fluid" style="font-size: 60px">
            <form action="/StuGradeManagerSystem_war/admin_updatemajor" method="post">
                <a>student id</a>
                <input placeholder="please enter the student id" name="id" class = "layui-input">
                <br/><br/>
                <a>major no</a>
                <input placeholder="please enter the major no" name="major" class = "layui-input">
                <br/><br/>
                <button type="submit" class = "layui-btn layui-btn-radius">submit</button>
                <br/>
            </form>
        </div>
    </div>
</div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright" align="center">South China Normal University</div>
</div>


</body>
</html>
