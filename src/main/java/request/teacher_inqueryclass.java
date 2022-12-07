package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/teacher_inqueryclass")
public class teacher_inqueryclass extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> Tech_list;
        DataControlCenter doc = new DataControlCenter();
        String id=new String();
        Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies){
            String name=cookie.getName();
            if("id".equals(name)){
                id=cookie.getValue();
                break;
            }
        }
        Tech_list = doc.getTeacherteachList(id);
        req.setAttribute("Tech_list",Tech_list);
        req.getRequestDispatcher("/teacher_ClassList.jsp").forward(req,res);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
