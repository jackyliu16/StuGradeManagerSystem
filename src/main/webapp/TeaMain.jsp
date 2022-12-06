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
	</style>

<meta charset="UTF-8">
<title>Student Achievement Management System</title>
</head>
<body>


	<!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#">Hello!!User</a><a href="#"></a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#9668;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','userinfo.html')">information</a></dd>             
              <dd><a href="login.jsp">exit</a></dd>
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
                <a _href="mainfunction.html">
                    <cite>Main Page</cite>
                </a>                                                       
             <li>
              <li>
                <a href="javascript:;">
                    <cite>Teacher action</cite>
                    <i class="nav_right">&#xe699;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="t_studentgradestatic.html">
                            <cite>Student achievement statistics</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="t_stugradelist.html">
                            <cite>Details of student achievements</cite>
                            
                        </a>
                    </li>
                    
                    <li>
                        <a _href="stu_manager.html">
                            <cite>Student management</cite>
                        </a>
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
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>Main Page</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='mainfunction.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright" align="center">华南师范大学</div>  
    </div>
 

</body>
</html>