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
	<title>list of student grades</title>
	</head>
	
	<body>
	<div class="x-body">
       <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="" id="searchByInfo"  method="post">               
          <input type="text" name="searchtime" id="searchtime" placeholder="Select a semester" autocomplete="off" class="layui-input">
          <button class="layui-btn layui-btn-danger"  onclick="searchByInfo()"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <hr color="green">
      <table class="layui-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Academy</th>            
            <th>Name</th>
            <th>StuNum</th>           
            <th>Subject</th>      
            <th>Grade</th>
            <th>ExamDate</th>  
            <th>AddDate</th>  
            <th>Other</th>        
        </thead>
        <tbody>
          <tr>          
            <td>1 </td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
           
            <td>
            9
            </td>
          </tr>
        </tbody>
      </table>
      
   <!--page begin-->
   <div class="am-cf">

   <div class="am-fr">
    <ul class="am-pagination">
      <li><a href="javascript:;" onclick="book_getFirstPage(this,'${sessionScope.currentPage}')" >Home</a></li>
      <li><a href="javascript:;" onclick="book_getPriverPage('${sessionScope.dataCount}','${sessionScope.currentPage}')" >Previous</a></li>
      <li><a href="javascript:;" onclick="book_getNextPage('${sessionScope.dataCount}','${sessionScope.currentPage}')" >Next</a></li>
      <li><a href="javascript:;" onclick="book_getLastPAge(this,'${sessionScope.dataCount}')" >Last</a></li>
    </ul>
  </div>
  </div>
  <!--page end-->
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
      
  }
  }
}


//--------------------mysql数据库分页显示操作---------------------------------
//首页
function book_getFirstPage(obj,currentPage){
   $("#sendOrder").attr("action","${pageContext.request.contextPath}/stuinfo?action=showBookData&currentPage=1").submit();  
}
//上一页
function book_getPriverPage(dataCount,currentPage){
   if(currentPage==1){
      layer.msg('First', {icon: 0.5});
   }else{
   $("#sendOrder").attr("action","${pageContext.request.contextPath}/stuinfo?action=showBookData&currentPage="+(currentPage-1)).submit();
  }
}
//下一页(注意，这里每页是10条记录)
function book_getNextPage(dataCount,currentPage){
   var endPage=Number(dataCount)/Number(10);
   if(currentPage>=endPage){
      layer.msg('Last', {icon: 0.5});
   }else{
    var nextPage=Number(currentPage)+Number(1);
    $("#sendOrder").attr("action","${pageContext.request.contextPath}/stuinfo?action=showBookData&currentPage="+nextPage).submit();
   }
}
//尾页
function book_getLastPAge(obj,dataCount){
    var laetPage= Math.ceil(dataCount/10);
    $("#sendOrder").attr("action","${pageContext.request.contextPath}/stuinfo?action=showBookData&currentPage="+laetPage).submit();  
}

</script>	
</body>
</html>