package request;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class myHttpServelet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String method=request.getMethod();
        if("GET".equals(method)){
            doGet(res,req);
        }else{
            doPost(res,req);
        }
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


    protected abstract void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException;

    protected abstract void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException;
}
