package MySocket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySeverSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        Socket socket=server.accept();//获取发出请求的客户端对象的Socket
        InputStream is=socket.getInputStream();
        byte[]b=new byte[2048];
        int len=is.read(b);
        System.out.println(new String(b,0,len));
        FileOutputStream fos=new FileOutputStream("C:\\Users\\子东\\Desktop\\chong.txt",true);
        fos.write(b,0,len);
        OutputStream os=socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        server.close();
    }
}
