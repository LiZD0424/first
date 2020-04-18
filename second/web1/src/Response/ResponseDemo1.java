package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo11111");
        response.setStatus(302);
        String contextPath = request.getContextPath();//动态获取虚拟目录，不建议将重定向中将虚拟目录写死，不然以后不好改
        response.setHeader("location",contextPath+"/responseDemo2");
       // response.sendRedirect("/web1/responseDemo2"); 重定向不用写上面的两句话

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
