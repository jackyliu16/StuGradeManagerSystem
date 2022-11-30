package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo1")
public class serveletDemo1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        System.out.println(method);

        String number=req.getParameter("number");
        System.out.println(number);

        /*req.setAttribute("msg","hello");
        Object msg=req.getAttribute("msg");*/ ////传数据

        req.getRequestDispatcher("/demo").forward(req,resp);////请求转发

        //响应数据
        resp.setContentType("text/html;charset=utf-8");
        //resp.setHeader("");
        PrintWriter writer=resp.getWriter();
        writer.write("<h1>hello</h1>");

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.doGet(req,resp);
    }
}
