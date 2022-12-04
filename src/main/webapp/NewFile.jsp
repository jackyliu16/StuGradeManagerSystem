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
<title>学生成绩管理系统</title>
</head>
<body>


	<!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#">学生成绩管理系统</a><a href="#"></a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','userinfo.html')">个人信息</a></dd>             
              <dd><a href="login.jsp">退出</a></dd>
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
                    <i class="iconfont">&#xe724;</i>
                    <cite>主页面</cite>
                </a>                                                       
             <li>
              <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>老师操作</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="t_studentgradestatic.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生成绩统计</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="t_stugradelist.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生成绩详情</cite>
                            
                        </a>
                    </li>
                    
                    <li>
                        <a _href="stu_manager.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生管理</cite>
                        </a>
                    </li>
                    
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>学生操作</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="studentgrade.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生成绩结果</cite>
                            
                        </a>
                    </li >
                   
                    <li>
                        <a _href="studentgradestatic.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生成绩统计</cite>
                            
                        </a>
                    </li>
                    
                </ul>
            </li>
           
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ae;</i>
                    <cite>系统管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="syslog.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>日志情况</cite>
                        </a>
                    </li >
                     
                     <li>
                        <a _href="th_manager.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>教师用户管理</cite>
                        </a>
                    </li >
                    
                    <li>
                        <a _href="authority_list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限管理</cite>
                        </a>
                    </li >
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
            <li>主页显示</li>
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