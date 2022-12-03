package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student_updatepwd")
public class student_updatepwd extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        Boolean result;
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
        result = doc.updateStudentPwd(id,req.getParameter("Oldpassword"),req.getParameter("Newpassword"));
        if(!result) {
            res.getWriter().println("<script>alert('Wrong password')</script>");
            res.getWriter().println("<script>window.location.href='./student_updatepwd.jsp'</script>");
        }
        else {
            res.getWriter().println("<script>alert('Change Successfully')</script>");
        }
        //System.out.println(result);
    }


}
