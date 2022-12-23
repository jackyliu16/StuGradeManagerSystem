package request;

import databasesOperation.DBException;
import databasesOperation.DBExceptionEnums;
import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_updatepwd")
public class teacher_updatepwd extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {

        Boolean result = false;
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

        try {
            result = doc.updateTeacherPwd(id,req.getParameter("Oldpassword"),req.getParameter("Newpassword"));
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
            res.getWriter().println("<script>alert('Wrong password')</script>");
            res.getWriter().println("<script>window.location.href='./teacher_updatepwd.jsp'</script>");
        }
        else {
            res.getWriter().println("<script>alert('Change Successfully')</script>");
            res.getWriter().println("<script>window.location.href='./teacher.jsp'</script>");
        }

    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doPost(res,req);
    }
}
