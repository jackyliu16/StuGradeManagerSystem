package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin_inquery")
public class admin_inquery extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {

        String type = req.getParameter("type");
        DataControlCenter dcc = new DataControlCenter();
        ArrayList<ArrayList<String>> result=new ArrayList<>();

        if(type.equals("student"))
        {
            result=dcc.getStudentList();
        }
        else if (type.equals("teacher"))
        {
            result=dcc.getTeacherList();
        }
        else if (type.equals("grade"))
        {
            result=dcc.getGradeList();
        }
        else
        {
            result=dcc.getClassList();
        }
        req.setAttribute("result",result);
        req.getRequestDispatcher("/admin_inquery.jsp").forward(req,res);

    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
