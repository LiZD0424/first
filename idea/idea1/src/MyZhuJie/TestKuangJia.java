package MyZhuJie;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestKuangJia {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        Class<Cal> calClass = Cal.class;
        Cal cal = calClass.newInstance();
        Method[] methods=calClass.getMethods();
        FileWriter fw=new FileWriter("C:\\Users\\子东\\Desktop\\ccc.txt",true);
        int num=0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)){//判断方法是否被Check标记
                try {
                    method.invoke(cal,1,0);
                } catch (Exception e) {
                    num++;
                    fw.write(method.getName()+"方法出异常了");
                    fw.write("\r\n");
                    fw.write("异常的名称"+e.getCause().getClass().getSimpleName());
                    fw.write("\r\n");
                    fw.write("异常的原因"+e.getCause().getMessage());
                    fw.write("\r\n");
                    fw.write("==============");
                    fw.write("\r\n");
                }
            }
        }
        fw.write("本次测试共出现了"+num+"次异常");
        fw.flush();
        fw.close();
    }
}
