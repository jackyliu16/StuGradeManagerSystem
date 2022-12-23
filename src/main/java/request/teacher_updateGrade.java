package request;

import databasesOperation.DBException;
import databasesOperation.DBExceptionEnums;
import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/teacher_updateGrade")
public class teacher_updateGrade extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        Boolean result = false;
        String stu_id=req.getParameter("stu_id");
        String course_id=req.getParameter("course_id");
        String grade = req.getParameter("grade");
        Double grade_number=Double.parseDouble(grade);
        DataControlCenter dcc = new DataControlCenter();

        try {
            result=dcc.updateStudentExCourseGrade(stu_id,course_id,grade_number);
        } catch (DBException e) {
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.PARAMETER_LENGTH_INCORRECT,
                    DBExceptionEnums.PARAMETER_TYPE_INCORRECT)) {
                res.getWriter().println("<script>alert('Parameter Illegal')</script>");
                res.getWriter().println("<script>window.location.href='./teacher.jsp'</script>");
            }
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.PARAMETER_NOT_EXIST)) {
                res.getWriter().println("<script>alert('PARAMETER NOT EXIST')</script>");
                res.getWriter().println("<script>window.location.href='./teacher.jsp'</script>");
            }
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.INTEGRITY_VIOLATION)) {
                res.getWriter().println("<script>alert('INTEGRITY_VIOLATION')</script>");
                res.getWriter().println("<script>window.location.href='./teacher.jsp'</script>");
            }
        }
        if(!result) {
            res.getWriter().println("<script>alert('Wrong ')</script>");
            res.getWriter().println("<script>window.location.href='./teacher_updateGrade.jsp'</script>");
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
