package request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class myHttpServelet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
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

    protected void doPost(ServletResponse res, ServletRequest req) throws ServletException, IOException {
    }

    protected void doGet(ServletResponse res, ServletRequest req) throws ServletException, IOException {
    }
}
