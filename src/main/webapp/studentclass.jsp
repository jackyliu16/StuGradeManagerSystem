<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">	
	<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
	<link rel="stylesheet" href="css/xadmin.css">
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
	<link rel="stylesheet" href="css/amazeui.min.css"/>
	
    <script src="scripts/jquery.min.js"></script>
    <script src="layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>

	<style type="text/css">
	a:link {
	text-decoration: none;
	color: black;
}
   .layui-table{
       width: 300px;
       border: 1px;
       margin-left: 200px;
   }*+p, *+hr, *+ul, *+ol, *+dl, *+blockquote, *+pre, *+address, *+fieldset, *+figure {
        margin-top: 0rem;
    }
    ol,ul{
        padding-left: 0em;
    }
	</style>

	<title>list of student grades</title>
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
              <dd><a onclick="x_admin_show('个人信息','information.jsp')">information</a></dd>             
              <dd><a href="login.jsp">exit</a></dd>
            </dl>
          </li>
        </ul>
    </div>
    <!-- 顶部结束 -->
	<div class="x-body">
       <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="" id="searchByInfo"  method="post">               
          <input type="text" name="searchtime" id="searchtime" placeholder="Select a semester" autocomplete="off" class="layui-input">
          <button class="layui-btn layui-btn-danger"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      
      <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
             <li>
                <a _href="NewFile1.jsp">
                    <cite>Main Page</cite>
                </a>                                                       
             <li>
             
            <li>
                <a href="javascript:;">
                    <cite>Student action</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <form action="/StuGradeManagerSystem_war/student_inquery" method="post" name="form1">
                            <a href="Javascript:document.form1.submit()">
                                <cite>Student achievement results</cite>
                            </a>
                        </form>
                    </li >
                    <li>
                        <form action="/StuGradeManagerSystem_war/student_inqueryclass" method="post" name="form2">
                            <a href="Javascript:document.form2.submit()">
                                <cite>Student belong class</cite>
                            </a>
                        </form>
                    </li>
                    <li>
                        <form action="/StuGradeManagerSystem_war/StuGradeStatic.jsp" method="post" name="form3">
                            <a href="Javascript:document.form3.submit()">
                                <cite>Student achievement statistics</cite>
                            </a>
                        </form>
                    </li>
                    <li>
                        <form action="/StuGradeManagerSystem_war/information.jsp" method="post" name="form4">
                            <a href="Javascript:document.form4.submit()">
                                <cite>information</cite>
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
      <hr color="green">
      <table class = "layui-table">


        <%
            ArrayList<ArrayList<String>>list;
            list = (ArrayList<ArrayList<String>>) request.getAttribute("Stu_class");
        %>

        <%
            for(int i=0;i<list.size();i=i+1)
            {
        %>
        <tr>
            <th><%=list.get(i).get(0)%></th>
            <th><%=list.get(i).get(1)%></th>
        </tr>
        <%
            }
        %>
      </table>
      

  </div>
 
 <!--用户操作使用form表单提交信息-->
 <form action="" id="sendOrder" name="sendOrder" method="post">
 </form> 
 <!--设置用来接受弹出窗口的整个form表单-->
 <div id="mianFromDiv" style="display:none;">
 </div>
 <!--弹框页面操作 end-->
 
<script>
//layui自启动
layui.use('layer', function(){
  $('.demo').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

//layui-date
layui.use('laydate', function(){
 var laydate = layui.laydate;
   //日期范围
   laydate.render({
    elem: '#searchtime'
    ,range: true
  });
  });









</script>	
</body>
</html>