<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/1
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student_inquery</title>
</head>
<body>
          <%
              String id=new String();
              Cookie[] cookies=request.getCookies();
              for(Cookie cookie:cookies){
                  String name=cookie.getName();
                  if("id".equals(name)){
                      id=cookie.getValue();
                      break;
                  }
              }
          %>
          <h1>hello! <%=id%></h1>
          ${Stu_id}

</body>
</html>
