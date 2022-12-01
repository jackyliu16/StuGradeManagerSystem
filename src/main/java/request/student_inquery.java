package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/student_inquery")
public class student_inquery extends myHttpServelet{
    @Override
    protected void doGet(ServletResponse res, ServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> Stu_id;
        DataControlCenter doc = new DataControlCenter();
        Stu_id = doc.getStudentCourseGrade("20200740001");/*req.getParameter("id")*/
        req.setAttribute("Stu_id", Stu_id);
        req.getRequestDispatcher("/student_inquery.jsp").forward(req,res);
        System.out.println(Stu_id);

    }

    @Override
    protected void doPost(ServletResponse res, ServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
