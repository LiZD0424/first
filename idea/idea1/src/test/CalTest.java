package test;
import MyZhuJie.Cal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalTest {
    @Before//在每次执行单元测试前执行，一般用于申请资源，初始化
    public void init(){
        System.out.println("init");
    }
    @After//在每次执行单元测试后执行，一般用于资源回收
    public void close(){
        System.out.println("close");
    }
    @Test
    public void addTest(){//一般返回值类型void，参数列表为空
        Cal cal=new Cal();
        int add = cal.add(1, 2);
        //断言
        Assert.assertEquals(3,add);//前面期望值，后面实际值
    }
}
