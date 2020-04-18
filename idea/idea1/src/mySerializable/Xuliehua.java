package mySerializable;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Xuliehua {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\子东\\Desktop\\ccc.txt",true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Stu stu = new Stu(1, "张三", true, "天津");
        oos.writeObject(stu);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("C:\\Users\\子东\\Desktop\\ccc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        System.out.println((Stu)object);
        ObjectMapper objectMapper = new ObjectMapper();
        FileOutputStream fos1 = new FileOutputStream("C:\\Users\\子东\\Desktop\\ccc.txt",true);
        objectMapper.writeValue(fos1,object);
        fos1.close();
    }

}
