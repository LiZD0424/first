package servlet;

import javax.servlet.*;
import java.io.IOException;

public class Demo1 implements Servlet {
    /**
     * 初始化方法，在servlet对象被创建时执行，只会执行一次
     * 说明只会产生一个Servlet对象，当多个用户同时访问同一个url时，可能会产生安全问题，所以尽量不要在类中定义成员变量，局部变量没有限制。或者不要去修改此成员变量。
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("1开启");
    }

    /**
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //提供服务的方法,每一次url被访问时都会执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("1111");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("1关闭");
    }
}
