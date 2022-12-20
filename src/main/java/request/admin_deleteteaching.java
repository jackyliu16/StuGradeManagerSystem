package request;

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

        String teacher_no = req.getParameter("teacher_id");
        String exclass_id = req.getParameter("exclass_id");

        DataControlCenter dcc = new DataControlCenter();
        Boolean result;

        result=dcc.deleteTeachingRelationship(teacher_no,exclass_id);

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
