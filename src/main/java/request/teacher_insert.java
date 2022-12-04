package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_insert")
public class teacher_insert extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        String stu_id=req.getParameter("stu_id");
        String course_id=req.getParameter("course_id");
        String grade = req.getParameter("grade");
        Double grade_number=Double.parseDouble(grade);
        DataControlCenter dcc = new DataControlCenter();

        dcc.updateStudentExCourseGrade(stu_id,course_id,grade_number);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
