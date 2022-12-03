package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/studentInfo")
public class studentInfo extends myHttpServelet{

    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> StuInfo;
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
        //System.out.println("id: "+id);
        StuInfo = doc.getStudentInfo(id);/*req.getParameter("id")*/
        req.setAttribute("StuInfo",StuInfo);
        req.getRequestDispatcher("/studentInfo.jsp").forward(req,res);

    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
