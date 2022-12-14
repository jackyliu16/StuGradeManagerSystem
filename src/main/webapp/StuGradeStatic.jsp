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
    <script src="js/echarts.min.js"></script>
        <style>
            *+p, *+hr, *+ul, *+ol, *+dl, *+blockquote, *+pre, *+address, *+fieldset, *+figure {
                margin-top: 0rem;
            }
            a:link {
                text-decoration: none;
                color: black;
            }
            ol,ul{
                padding-left: 0em;
            }
        </style>
	<title>Statistics of student grade</title>
	</head>
	
	<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#">Hello!!Student</a><a href="#"></a></div>
        <div class="left_open">
            <i title="Expand list" class="iconfont">&#9668;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
            <li class="layui-nav-item">
                <a href="javascript:">student</a>
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
                        <a href="javascript:">
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
	<div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/StuGradeManagerSystem_war/studentDump" id="searchByInfo"  method="post">
          
          <input class="layui-input" placeholder="exclass" name="exclass" id="examWeek">
          <button class="layui-btn layui-btn-danger" onclick="searchByInfo()"><i class="layui-icon">&#xe615;</i>
          </button>
        </form>
      </div>
      <hr>
      <table class="layui-table">
          <%
              ArrayList<ArrayList<String>>list;
              list = (ArrayList<ArrayList<String>>) request.getAttribute("Stu_id");
          %>

          <%
              for(int i=0;i<list.size();i=i+1)
              {
          %>
          <tr>
              <th><%=list.get(i).get(0)%></th>
              <th><%=list.get(i).get(1)%></th>
              <th><%=list.get(i).get(2)%></th>
              <th><%=list.get(i).get(3)%></th>
              <th><%=list.get(i).get(4)%></th>
              <th><%=list.get(i).get(5)%></th>
          </tr>
          <%
              }
          %>
      </table>
  </div>
 <hr class="layui-bg-green">
 <!--echart_part-->
 <div id="container"  style="height: 380px"></div>

    <div class="footer">
        <div class="copyright" align="center">South China Normal University</div>
    </div>
    </div>
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


//图书信息搜索
/*function searchByInfo(){
  var getBookName = $("#bookname").val();
  var getBookauthor = $("#author").val();
  var form = document.getElementById("searchByInfo");
  form.onsubmit = function(form){
  if (getBookName == "" && getBookauthor == ""){
	  layer.msg('至少填写一个查询信息', {icon: 0.5});
	  return false;
   }else{ 
      $("#searchByInfo").attr("action","${pageContext.request.contextPath}/StuGradeStatic.jsp?action=searchByCnd&bookname="+getBookName+"&bookauthor="+getBookauthor).submit();
  }
  }
}*/
</script>



<script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    title: {
        text: 'Percentage of student achievement bands',
        subtext: 'Fan chart',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['0~60', '60~70', '70~80', '80~90', '90~100']
    },
    series: [
        {
            name: 'Fractional segment',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: ${a}, name: '0~60'},
                {value: ${b}, name: '60~70'},
                {value: ${c}, name: '70~80'},
                {value: ${d}, name: '80~90'},
                {value: ${e}, name: '90~100'}
            ],
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
</script>
</body>
</html>