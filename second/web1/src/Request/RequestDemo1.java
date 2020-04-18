package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* BufferedReader reader = request.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        request.setCharacterEncoding("utf-8");//防止乱码问题，获取流之前
        String referer = request.getHeader("Referer");
        System.out.println("referer:" + referer);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL:" + requestURL);
        String[] pass = request.getParameterValues("password");
        System.out.println(pass);
        for (String s : pass) {
            System.out.println(s);
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            String[] s=next.getValue();
            for (String s1 : s) {
                System.out.println(next.getKey()+":"+s1);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
