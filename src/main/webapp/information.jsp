<%@ page import="databasesOperation.DataControlCenter" %>
<%@ page import="databasesOperation.DBException" %>
<%@ page import="databasesOperation.DBExceptionEnums" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	  content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
<link type="text/css" rel="stylesheet" href="css/font.css"/>


<!--basic_css-->
	<link rel="stylesheet" href="css/xadmin.css" type = "text/css">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" type = "text/css">
    <link rel="stylesheet" href="css/amazeui.min.css"/>

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
	<title>用户信息页面</title>

    <style>
   
    *+p, *+hr, *+ul, *+ol, *+dl, *+blockquote, *+pre, *+address, *+fieldset, *+figure{
margin-top: 0rem;
}
.layui-tab {
    margin: -5px 0;

}
	ol,ul{
		padding-left: 0em;
	}
	.iii{
		width: 135px;
		padding-left: 0px;
	}
	.ii{
		width: 110px;
		padding-left: 0px;
	}
    </style>
	</head>
	<body>
  <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#">Hello!!Student</a><a href="#"></a></div>
        <div class="left_open">
            <i title="Expand left" class="iconfont">&#9668;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">student</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
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
				 <form action="/StuGradeManagerSystem_war/StuMain.jsp" method="post" name="form5">
					 <a href="Javascript:document.form5.submit()">
						 <cite>Main Page</cite>
					 </a>
				 </form>
             <li>
             
            <li>
                <a href="javascript:;">
                    <cite>Student action</cite>
                </a>
                <ul class="sub-menu">
					<li>
						<form action="/StuGradeManagerSystem_war/student_inquery" method="post" name="form1">
							<a href="Javascript:document.form1.submit()">
								<cite>Student Grade List</cite>
							</a>
						</form>
					</li >
					<li>
						<form action="/StuGradeManagerSystem_war/student_inqueryclass" method="post" name="form2">
							<a href="Javascript:document.form2.submit()">
								<cite>Student Class List</cite>
							</a>
						</form>
					</li>
					<li>
						<form action="/StuGradeManagerSystem_war/StuGradeStaticpost.jsp" method="post" name="form3">
							<a href="Javascript:document.form3.submit()">
								<cite>Student Grade Statistics</cite>
							</a>
						</form>
					</li>
					<li>
						<form action="/StuGradeManagerSystem_war/information.jsp" method="post" name="form4">
							<a href="Javascript:document.form4.submit()">
								<cite>Information</cite>
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
    
    <div class="page-content">
		<%
			String id = new String();
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("id".equals(name)) {
					id = cookie.getValue();
					break;
				}
			}
			DataControlCenter dcc = new DataControlCenter();
			try {
				String name = dcc.getStudentName(id);
			} catch (DBException e) {
				// NOTE module of exception operation
				if (DBException.checkIfExceptionInCollections(e,
						DBExceptionEnums.PARAMETER_NOT_EXIST)) {
					System.out.println("student not exist");
					// TODO add message handler of student not exist
				} else {
					// TODO add normal message handler (i guess it will never have other error)
				}
			}
		%>
	<div class="layui-tab page-content-wrap long">
		  <ul class="layui-tab-title">
		    <li class="layui-this">Change Information</li>
		    <li >Change Password</li>
		  </ul>
		  <div class="layui-tab-content">
		    <div class="layui-tab-item layui-show">
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;">
				   <div class="layui-form-item">
					   <label class="layui-form-label iii">ID：<%=id%></label>
				   </div>
					<div class="layui-form-item">
				      <label class="layui-form-label ii">Name：<%=name%></label>
				    </div>
				   <div class="layui-form-item">
				    <label class="layui-form-label ">Password：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password" required  lay-verify="required" autocomplete="off" class="layui-input" value="123456">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label ">e-mail：</label>
				    <div class="layui-input-block">
				      <input type="text" name="email" required  lay-verify="required" autocomplete="off" class="layui-input" value="5303588521@qq.com">
				    </div>
				  </div>
				  <div class="layui-form-item layui-form-text">
				    <label class="layui-form-label ">other：</label>
				    <div class="layui-input-block">
				      <textarea name="desc" placeholder="Please input context" class="layui-textarea"></textarea>
				    </div>
				  </div>
				  <%--<div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
				    </div>
				  </div>--%>
				</form>
		    </div>
		    <div class="layui-tab-item">
		    	<form class="layui-form" v style="width: 90%;padding-top: 20px;" action="/StuGradeManagerSystem_war/student_updatepwd" method="post">
					<div class="layui-form-item">
						<label class="layui-form-label iii">ID：<%=id%></label>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ii">Name：<%=name%></label>
					</div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">OldPassword：</label>
				    <div class="layui-input-block">
						  <input type="password" name="oldpassword" required lay-verify="required" placeholder="Please input old password" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">NewPassword：</label>
				    <div class="layui-input-block">
				      <input type="password" name="newpassword" required lay-verify="required" placeholder="Please input new password" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">Repeat：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password" required lay-verify="required" placeholder="Please repeat new password" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword">Submit</button>
				    </div>
				  </div>
				</form>
		    </div>
		  </div>
	</div>
	
    </div>
    
    
    <div class="footer">
        <div class="copyright" align="center">South China Normal University</div>
    </div>
    
    
	<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
		//Demo
		layui.use(['form','element'], function(){
		  var form = layui.form();
		  var element = layui.element();
		  form.render();
		  //监听信息提交
		  form.on('submit(adminInfo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		  //监听密码提交
		   form.on('submit(adminPassword)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		
		//layui自启动
		layui.use('layer', function(){
		  $('.demo').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
	</script>
	    
	</body>
</html>