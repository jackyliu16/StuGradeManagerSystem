package request;

import databasesOperation.DBException;
import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admin_deleteteaching")
public class admin_deleteteaching extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {

        String teacher_no = req.getParameter("teacher_no");
        String exclass_id = req.getParameter("exclass_id");

        DataControlCenter dcc = new DataControlCenter();
        Boolean result;

        try {
            result=dcc.deleteTeachingRelationship(teacher_no,exclass_id);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }

        if(result){
            res.getWriter().println("<script>alert('Register success')</script>");
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
