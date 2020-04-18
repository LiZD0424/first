package MyIO;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 字节输出流使用步骤：
 * 1.创建一个FileInputStream对象，构造方法中传递读取数据的地点
 * 2.调用FileInputStream对象中的方法read，读取文件
 * 3.释放资源
 * */
public class MyInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\子东\\Desktop\\chong.txt");
        int read = fis.read();//读一个字符并返回读到的值，然后把指针指向下一个字节 遇到文件结尾返回-1
        System.out.println(read);
        int a = 0;
        while ((a = fis.read()) != -1) {
            System.out.println(a);
        }
        fis.close();

        FileInputStream fis1 = new FileInputStream("C:\\Users\\子东\\Desktop\\chong.txt");
        byte[] bytes = new byte[20];
        int read1 = fis1.read(bytes);//read返回的int型数据为字节数组内有效字节的长度，读取的数据已经存储在bytes数组中了，-1为文件末尾 数组中无有效字符
        String s = new String(bytes);
        System.out.println(read1 + s);
        fis1.close();

        FileInputStream fis2 = new FileInputStream("C:\\Users\\子东\\Desktop\\chong.txt");
        byte[] b = new byte[1024];
        int len=0;
        while((len= fis2.read(b))!= -1){
            String s1=new String(b,0,len);//字节数组b从索引0开始len长度转换为字符串
            System.out.println(s1);
        }
        fis2.close();
    }
}
