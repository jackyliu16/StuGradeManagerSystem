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
        Boolean result;
        String stu_id=req.getParameter("stu_id");
        String course_id=req.getParameter("course_id");

        DataControlCenter dcc = new DataControlCenter();

        result=dcc.insertStudentIntoExCourse(stu_id,course_id);
        if(!result) {
            res.getWriter().println("<script>alert('Wrong ')</script>");
            res.getWriter().println("<script>window.location.href='./teacher_insert.jsp'</script>");
        }
        else {
            res.getWriter().println("<script>alert('update Successfully')</script>");
            res.getWriter().println("<script>window.location.href='./teacher.jsp'</script>");
        }
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
