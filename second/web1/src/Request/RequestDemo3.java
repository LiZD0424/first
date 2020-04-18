package Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo3333被访问");
        request.setAttribute("1","hello");//request共享域对象（键值对）
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo2");//获取转发器对象
        requestDispatcher.forward(request,response);//调用forward方法转发
        System.out.println("7777");


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
