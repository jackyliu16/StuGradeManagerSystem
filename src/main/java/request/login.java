package request;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databasesOperation.DataControlCenter;
import tool.LogLevel;
import tool.Logger;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

@WebServlet("/login")
public class login extends HttpServlet {
    static final Logger log = Logger.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.setLogLevel(LogLevel.Debug);
        log.debug("hello, world");
        String id=req.getParameter("id");
        String password=req.getParameter("password");
        String status = req.getParameter("status");
        DataControlCenter dcc = new DataControlCenter();

        Cookie cookie=new Cookie("id",id);
        res.addCookie(cookie);

       if(status.equals("student")){
            //*ArrayList<ArrayList<String>> data = dcc.getStudentCourseGrade(id);*//*
            if(dcc.checkStudentPwd(id,password)){
                req.getRequestDispatcher("/StuMain.jsp").forward(req,res);
            }
        }
        else if (status.equals("teacher")) {
            if(dcc.checkTeacherPwd(id,password)){
                req.getRequestDispatcher("/teacher.jsp").forward(req,res);
            }
        }
        else if (status.equals("admin")){
            if(dcc.checkAdminPwd(id,password)){
                req.getRequestDispatcher("/admin.jsp").forward(req,res);
            }
        }
        else{
           res.getWriter().println("<script>alert('Wrong Type')</script>");
           res.getWriter().println("<script>window.location.href='./login.jsp'</script>");
       }
        res.getWriter().println("<script>alert('Wrong password or ID')</script>");
        res.getWriter().println("<script>window.location.href='./login.jsp'</script>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
