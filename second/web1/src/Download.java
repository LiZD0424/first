import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        System.out.println(filename);
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/imag/" + filename);//获取文件真实路径，即服务器文件路径
        System.out.println(realPath);
        FileInputStream fi = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);//只是根据文件后缀名判断mime类型，故不需要相对路径
        response.setHeader("content-type",mimeType);//告诉浏览器本次响应体数据格式与编码格式
        response.setHeader("content-disposition","attachment;filename="+filename);//指定response响应头告诉浏览器以什么方式打开响应体，定义为附件
        ServletOutputStream sos = response.getOutputStream();
        byte[] b=new byte[1024*10];
        int len=0;
        while((len=fi.read(b))!=-1){
            sos.write(b,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
