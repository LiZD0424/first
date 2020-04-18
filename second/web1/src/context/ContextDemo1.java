package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/contextDemo1")
public class ContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext servletContext = request.getServletContext();两种方式获取ServletContext
        ServletContext servletContext1 = this.getServletContext();
        String realPath = servletContext1.getRealPath("/b.txt");
        String realPath1 = servletContext1.getRealPath("/WEB-INF/c.txt");
        String realPath2 = servletContext1.getRealPath("/WEB-INF/classes/a.txt");//src目录下文件可以用类加载器加载，但类加载器不能获取web目录下的文件
        File file = new File(realPath);
        FileInputStream fileInputStream = new FileInputStream(realPath2);
        byte[] b=new byte[1024];
        int len= fileInputStream.read(b);
        String s=new String(b,0,len);
        System.out.println(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
