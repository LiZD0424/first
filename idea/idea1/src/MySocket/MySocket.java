package MySocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//客户端创建Socket对象的时候就已经和服务器三次握手了，如果服务器没有启动，那么就会抛异常
//服务器与客服端交互必须使用Socket中提供的网络流，不能自己创建输入输出流
public class MySocket {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);//ip地址，端口号
        OutputStream outputStream=socket.getOutputStream();
       // outputStream.write("你好服务器".getBytes());
        FileInputStream fis=new FileInputStream("C:\\Users\\子东\\Desktop\\chong.txt");
        byte[]a=new byte[1024];
        int n=0;
        n=fis.read(a);
        System.out.println(new String(a));
        outputStream.write(a,0,n);
        InputStream is=socket.getInputStream();
        byte[]b=new byte[1024];
        int len=is.read(b);
        System.out.println(new String(b,0,len));
        socket.close();
    }
}
