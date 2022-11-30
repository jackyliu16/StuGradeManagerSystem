package request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import databasesOperation.DataControlCenter;

import java.io.IOException;
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
            ArrayList<ArrayList<String>> data = dcc.getStudentCourseGrade(id);
        }
        else if (status.equals("teacher")) {
            req.getRequestDispatcher("/teacher.jsp").forward(req,res);
        }
        else {

        }
        System.out.println(id);
    }

    @Override
    protected void doPost(ServletResponse res, ServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
