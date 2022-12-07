package request;

import databasesOperation.DataControlCenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/studentDump")
public class studentDump extends myHttpServelet{

    @Override
    protected void doPost(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        ArrayList<ArrayList<String>> Stu_Rank;
        DataControlCenter doc = new DataControlCenter();
        /*String id=new String();
        Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies){
            String name=cookie.getName();
            if("id".equals(name)){
                id=cookie.getValue();
                break;
            }
        }*/

        int a=0,b=0,c=0,d=0,e=0;
        String exclass=req.getParameter("exclass");
        Stu_Rank = doc.getStudentInfoBelongExCourse(exclass);
        for(int i = 1 ; i < Stu_Rank.size() ; i++){
            //System.out.println(Double.parseDouble(Stu_Rank.get(i).get(4)));
            if(Double.parseDouble(Stu_Rank.get(i).get(4))<60 && Double.parseDouble(Stu_Rank.get(i).get(4))>0)
            {
                a++;
            }
            if(Double.parseDouble(Stu_Rank.get(i).get(4))<70 && Double.parseDouble(Stu_Rank.get(i).get(4))>=60)
            {
                b++;
            }
            if(Double.parseDouble(Stu_Rank.get(i).get(4))<80 && Double.parseDouble(Stu_Rank.get(i).get(4))>=70)
            {
                c++;
            }
            if(Double.parseDouble(Stu_Rank.get(i).get(4))<90 && Double.parseDouble(Stu_Rank.get(i).get(4))>=80)
            {
                d++;
            }
            if(Double.parseDouble(Stu_Rank.get(i).get(4))<=100 && Double.parseDouble(Stu_Rank.get(i).get(4))>=90)
            {
                e++;
            }
        }

        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("c", c);
        req.setAttribute("d", d);
        req.setAttribute("e", e);
        req.getRequestDispatcher("/StuGradeStatic.jsp").forward(req,res);
    }

    @Override
    protected void doGet(HttpServletResponse res, HttpServletRequest req) throws ServletException, IOException {
        this.doGet(res,req);
    }
}
