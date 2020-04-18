package Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody//不加这个默认跳转的是templates中的hello.html页面
    public String hello(){
        return "hello";
    }
}
