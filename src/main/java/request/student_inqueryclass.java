package request;

import databasesOperation.DBException;
import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/student_inqueryclass")
public class student_inqueryclass extends myHttpServelet{

    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> Stu_class;
        DataControlCenter doc = new DataControlCenter();
        String id=new String();
        Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies){
            String name=cookie.getName();
            if("id".equals(name)){
                id=cookie.getValue();
                break;
            }
        }
        try {
            Stu_class = doc.getStudentExClassHistory(id);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
/*      String strRequest = "request传值";
        String strSession = "session传值";
        request.setAttribute("strRequest", strRequest);
        request.getSession().setAttribute("strSession", strSession);
//JSP
<%
        String strRequest = (String)request.getAttribute("strRequest");
        String strSession = (String)request.getSession().getAttribute("strSession");
%>*/

        req.setAttribute("Stu_class", Stu_class);
        req.getRequestDispatcher("/studentclass.jsp").forward(req,res);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
