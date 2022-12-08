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

    </style>
    <title>List Of Student Grade</title>
</head>

<body>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="" id="searchByInfo"  method="post">
            <input class="layui-input" placeholder="CourseID" name="CourseID" id="CourseID">
            <input type="text" name="ID" id="ID" placeholder="ID" autocomplete="off" class="layui-input">
            <button class="layui-btn layui-btn-warm" onclick="searchByInfo()"><i class="layui-icon">&#xe615;</i>
            </button>
        </form>
    </div>
    <hr color="green">
    <table class="layui-table">
        <%
            ArrayList<ArrayList<String>>list;
            list = (ArrayList<ArrayList<String>>) request.getAttribute("Grade_list");
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
        </tr>
        <%
            }
        %>
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