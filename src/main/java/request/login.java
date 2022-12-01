package request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import databasesOperation.DataControlCenter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/login")
public class login extends myHttpServelet {
    @Override
    protected void doGet(ServletResponse res, ServletRequest req) throws ServletException, IOException {

        String id=req.getParameter("id");
        String password=req.getParameter("password");
        String status=req.getParameter("status");
        DataControlCenter dcc = new DataControlCenter();

        if(status.equals("student")){
            /*ArrayList<ArrayList<String>> data = dcc.getStudentCourseGrade(id);*/
            if(dcc.checkStudentPwd(id,password)){
                req.getRequestDispatcher("/student.jsp").forward(req,res);
            }
        }
        else if (status.equals("teacher")) {
            if(dcc.checkTeacherPwd(id,password)){
                req.getRequestDispatcher("/teacher.jsp").forward(req,res);
            }
        }
        else {
            if(dcc.checkAdminPwd(id,password)){
                req.getRequestDispatcher("/admin.jsp").forward(req,res);
            }
        }
        res.getWriter().println("<script>alert('Wrong password or ID')</script>");
        res.getWriter().println("<script>window.location.href='./login.html'</script>");
        System.out.println(id);
    }

    @Override
    protected void doPost(ServletResponse res, ServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
