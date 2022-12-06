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
	<title>Exam score information</title>
	</head>
	
	<body>
	<div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="" id="searchByInfo"  method="post">
          
          <input class="layui-input" placeholder="semester" name="examWeek" id="examWeek">
          <input class="layui-input" placeholder="subject" name="examSub" id="examSub">                    
          <button class="layui-btn layui-btn-danger" onclick="searchByInfo()"><i class="layui-icon">&#xe615;</i>
          </button>
        </form>
      </div>
      <hr>
      <table class="layui-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>StuNum</th>
            <th>subject</th>
            <th>ExamDate</th>      
            <th>grade</th>       
        </thead>
        <tbody>
        <%
            ArrayList<ArrayList<String>>list;
            list = (ArrayList<ArrayList<String>>) request.getAttribute("Stu_id");
        %>

        <%
            for(int i=0;i<list.size();i=i+1)
            {
        %>
            <tr>
            <td><%=list.get(i).get(0)%></td>
            <td><%=list.get(i).get(1)%></td>
            </tr>

        <%
            }
        %>
          <tr>
            <td>1</td>
            <td>张三</td>
            <td>2020124213</td>
            <td>计算机基础</td>
            <td>期末</td>
            <td>78</td>
          </tr>
          
        </tbody>
      </table>
  </div>
 <hr class="layui-bg-green">
 <!--echart_part-->
 <div id="container"  style="height: 380px"></div>
 
<!--
	作者：offline
	时间：2021-01-19
	描述：基本操作的js内容
--> 
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
function searchByInfo(){
  var getBookName = $("#bookname").val();
  var getBookauthor = $("#author").val();
  var form = document.getElementById("searchByInfo");
  form.onsubmit = function(form){
  if (getBookName == "" && getBookauthor == ""){
	  layer.msg('至少填写一个查询信息', {icon: 0.5});
	  return false;
   }else{ 
      $("#searchByInfo").attr("action","${pageContext.request.contextPath}/BookServlet?action=searchByCnd&bookname="+getBookName+"&bookauthor="+getBookauthor).submit();
  }
  }
}
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
        data: ['0~20', '20~40', '40~60', '60~80', '80~100']
    },
    series: [
        {
            name: 'Fractional segment',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 3, name: '0~20'},
                {value: 4, name: '20~40'},
                {value: 6, name: '40~60'},
                {value: 1, name: '60~80'},
                {value: 2, name: '80~100'}
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