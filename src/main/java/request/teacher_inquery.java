package request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher_inquery")
public class teacher_inquery extends myHttpServelet{
    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {

    }


}
