package Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo222222222");
        System.out.println(request.getHeader("referer"));
        response.setCharacterEncoding("utf-8");//获取流之前设置编码,不区分大小写，
        response.setHeader("Content-Type"," text/html;charset=UTF-8");//告诉浏览器消息体的编码格式
        //response.setContentType("text/html;charset=UTF-8");上面的简单写法
        PrintWriter writer = response.getWriter();
        writer.write("你好");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好呀".getBytes("utf-8"));//也可设置编码，不能和字符流一起用
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
