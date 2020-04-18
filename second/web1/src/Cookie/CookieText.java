package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet("/CookieText")
public class CookieText extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag=false;
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("lastTime".equals(cookie.getName())){
                    String str=cookie.getValue();
                    String decode = URLDecoder.decode(str, "utf-8");//URL解码
                    response.getWriter().write("您上次访问的时间是"+decode);
                    Date date=new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = simpleDateFormat.format(date);
                    String encode = URLEncoder.encode(format, "utf-8");//特殊字符空格需要URL转码，然后再解码
                    cookie.setValue(encode);
                    response.addCookie(cookie);
                    flag=true;
                    break;
                }
            }
        }
        if(cookies==null||!flag){
            Date date=new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = simpleDateFormat.format(date);
            String encode = URLEncoder.encode(format, "utf-8");
            Cookie lastTime = new Cookie("lastTime", encode);
            response.addCookie(lastTime);
            response.getWriter().write("您是首次访问");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
