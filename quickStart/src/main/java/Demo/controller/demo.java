package Demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//不写RestController就得写@ResponseBody
@Controller//返回页面只能用controller ，字符串等可以用Restcontroller或者controller+responseBody
public class demo {
    @Value("${name}")
    private String name;
    @Value("${student.address}")
    private String addr;
    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        return name+addr;
    }
}
