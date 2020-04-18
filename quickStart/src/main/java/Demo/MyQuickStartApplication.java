package Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//声明该类是SpringBoot工程的引导类，就是一个入口
public class MyQuickStartApplication {
    public static void main(String[] args) {
        //run方法运行的是引导类
        SpringApplication.run(MyQuickStartApplication.class,args);
    }
}

