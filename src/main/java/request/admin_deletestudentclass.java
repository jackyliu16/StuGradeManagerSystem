package request;

import databasesOperation.DBException;
import databasesOperation.DBExceptionEnums;
import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_deletestudentclass")
public class admin_deletestudentclass extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        String id = req.getParameter("stu_id");
        String exclass_id = req.getParameter("exclass_id");

        DataControlCenter dcc = new DataControlCenter();
        Boolean result = false;

        try {
            result=dcc.deleteStudentFromExCourse(id,exclass_id);
        } catch (DBException e) {
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.PARAMETER_LENGTH_INCORRECT,
                    DBExceptionEnums.PARAMETER_TYPE_INCORRECT)) {
                res.getWriter().println("<script>alert('Parameter Illegal')</script>");
                res.getWriter().println("<script>window.location.href='./admin.jsp'</script>");
            }
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.PARAMETER_NOT_EXIST)) {
                res.getWriter().println("<script>alert('PARAMETER NOT EXIST')</script>");
                res.getWriter().println("<script>window.location.href='./admin.jsp'</script>");
            }
            if (DBException.checkIfExceptionInCollections(e,
                    DBExceptionEnums.INTEGRITY_VIOLATION)) {
                res.getWriter().println("<script>alert('INTEGRITY_VIOLATION')</script>");
                res.getWriter().println("<script>window.location.href='./admin.jsp'</script>");
            }
        }

        if(result){
            res.getWriter().println("<script>alert('Delete success')</script>");
        }
        else {
            res.getWriter().println("<script>alert('Wrong')</script>");
        }
        res.getWriter().println("<script>window.location.href='./admin.jsp'</script>");
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
