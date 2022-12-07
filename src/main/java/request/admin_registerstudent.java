package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_registerstudent")
public class admin_registerstudent extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {

        String id = req.getParameter("id");
        String Name = req.getParameter("Name");
        String No = req.getParameter("No");
        String pwd = req.getParameter("pwd");
        DataControlCenter dcc = new DataControlCenter();
        Boolean result;

        result=dcc.insertNewStudentUser(id,Name,No,pwd);

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
