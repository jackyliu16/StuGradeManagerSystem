package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/student_inquery")
public class student_inquery extends myHttpServelet{

    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> Stu_id;
        DataControlCenter doc = new DataControlCenter();
        Stu_id = doc.getStudentCourseGrade("20200740001");/*req.getParameter("id")*/
        req.setAttribute("Stu_id", Stu_id);
        String id=new String();
        Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies){
            String name=cookie.getName();
            if("id".equals(name)){
                id=cookie.getValue();
                break;
            }
        }
        System.out.println("id: "+id);
        Stu_id = doc.getStudentCourseGrade(id);/*req.getParameter("id")*/
        req.setAttribute("Stu_id",Stu_id);
        req.getRequestDispatcher("/student_inquery.jsp").forward(req,res);

    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
