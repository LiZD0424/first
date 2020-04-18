package MyIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
* FileOutputStream构造方法首先会创建一个FileOutputStream对象，然后会根据构造方法的参数创建一个文件，最后把FileOutputStream对象指向该文件
* 字节输出流使用步骤：
* 1.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
* 2.调用FileOutputStream对象中的方法write，把数据写入文件
* 3.释放资源
* */
public class MyOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\子东\\Desktop\\chong.txt");
        //fos.write(65);//ASCII码
        //fos.close();
        /*
        *  void write(int b) 将指定字节写入此文件输出流。
        *  void write(byte[] b) 将 b.length 个字节从指定 byte 数组写入此文件输出流中。若第一个字符是（0-127）会根据ASCLL码表；若第一个字符是负数，那第一个字节和第二个字节会组合成一个中文显示，根据系统默认码表（GBK）
           void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        * */
        byte[] bytes1={64,65,66,67,68};
        byte[] bytes2={-64,-65,-66,67,68};//-64,-65；-66，-67两两组成中文68查询ASCLL码
        fos.write(bytes2);
        fos.write(bytes1,1,2);//从下标1开始的两个元素
        byte[] bytes3="你好".getBytes();
        System.out.println(Arrays.toString(bytes3));//[-28, -67, -96, -27, -91, -67]UTF-8三个字节一个中文
        fos.write(bytes3);
        fos.close();
        /*
        * 续写：
        * FileOutputStream(File file, boolean append)
          创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
          FileOutputStream(String name, boolean append)
          创建一个向具有指定 name 的文件中写入数据的输出文件流。
          append:续写开关，true为续写
          换行：
          windows是\r\n
          Linux是/n
          mac是/r
        * */

        FileOutputStream fos1=new FileOutputStream("C:\\Users\\子东\\Desktop\\chong.txt",true);
        fos1.write("\r\n".getBytes());
        fos1.write(bytes1);
        fos1.close();
    }

}
