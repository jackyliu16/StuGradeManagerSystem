package request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/teacher_inquery")
public class teacher_inquery extends myHttpServelet{
    @Override
    protected void doGet(ServletResponse res, ServletRequest req) {



    }

    @Override
    protected void doPost(ServletResponse res, ServletRequest req) {
        this.doGet(res,req);
    }
}
