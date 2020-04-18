package MyIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WenJianFuZhi {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\子东\\Desktop\\ssss\\3333.jpg",true);
        FileInputStream fis=new FileInputStream("C:\\Users\\子东\\Desktop\\ssss\\多态.jpg");


        int n=0;
        long s1=System.currentTimeMillis();
        while((n=fis.read())!=-1){
            fos.write(n);
        }
        long e1=System.currentTimeMillis();
        System.out.println("单字节复制耗时"+(e1-s1)+"毫秒");
        fos.close();//先关写再关读，写完一定读完了
        fis.close();

        FileOutputStream fos1=new FileOutputStream("C:\\Users\\子东\\Desktop\\ssss\\3333.jpg");
        FileInputStream fis1=new FileInputStream("C:\\Users\\子东\\Desktop\\ssss\\集合.jpg");
        byte[] b=new byte[300000];
        int len=0;
        long s2=System.currentTimeMillis();
        while((len=fis1.read(b))!=-1){
            fos1.write(b);
        }
        long e2=System.currentTimeMillis();
        System.out.println("缓冲区复制耗时"+(e2-s2)+"毫秒");
        fos1.close();
        fis1.close();
    }

}
