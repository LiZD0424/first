package MyIO;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWrite {
    /*
     *1.创建FileWrite对象，构造方法中参数为写入数据目的地
     * 2.使用write方法，把数据写入内存缓冲区中（字符转换为字节的过程）
     * 3.使用flush方法，把内存区中的数据刷新到文件中
     * 4.释放资源（会先把内存区中的数据刷新到文件中）
     * */
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\子东\\Desktop\\chong.txt");
        fw.write(65);
        fw.flush();//将内存缓冲区中的字符刷新到文件中，不会关闭流对象
        fw.close();//关闭流对象，之后不能再使用

        FileWriter fw1=new FileWriter("C:\\Users\\子东\\Desktop\\chong.txt",true);
        fw1.write("你好");
        fw1.write("123456",0,3);//字符串，起始点，长度
        char[] c={'a','b','c'};
        fw1.write(c);
        fw1.write(c,0,2);
        fw1.flush();
        fw1.close();

    }
}
