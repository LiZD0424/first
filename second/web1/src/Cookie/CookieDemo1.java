package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "hello");
        cookie.setMaxAge(30);//持久化到硬盘，即使浏览器被关闭也能再次访问到此cookie，30s后删除，负数为默认值，0为主动删除硬盘和内存中的cookie
        cookie.setPath("/");//默认值为/web1 ，设置成这样变为根目录，同一个tomcat下不同的web项目也能访问了
        //cookie.setDomain(".baidu.com");不同服务器一级域名相同也可以共享cookie
        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
