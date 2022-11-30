package request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/teacher_insert")
public class teacher_insert extends myHttpServelet{
    @Override
    protected void doPost(ServletResponse res, ServletRequest req) {



    }

    @Override
    protected void doGet(ServletResponse res, ServletRequest req) {
        this.doPost(res,req);
    }
}
