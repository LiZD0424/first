package MyIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class MyProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();//默认<String，String>
        properties.setProperty("张三", "1111");
        properties.setProperty("李四", "2222");
        Set<String> key = properties.stringPropertyNames();//把properties集合中的键取出，存储到set集合中
        Iterator<String> iterator = key.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str + "=" + properties.getProperty(str));
        }
        /*
         *  void store(Writer writer, String comments) 字符流可以写中文
         *  void store(OutputStream out, String comments)字节流不能输中文
         * */
        FileWriter fw = new FileWriter("C:\\Users\\子东\\Desktop\\chong.txt");
        properties.store(fw, "");
        fw.close();

        /*
        *  void load(Reader reader)字符流可以读入中文
        *  void load(InputStream inStream)字节流不能读入中文
        *
        *  注意事项：
        *  1.存储键值对的文件中，键与值默认连接符可以是=，空格（其他符号）
        *  2.文件中，可以使用#来进行注释
        *  3.文件中，键与值默认都是字符串。不用再加引号了
        * */
        Properties p=new Properties();
        FileReader fr=new FileReader("C:\\Users\\子东\\Desktop\\chong.txt");
        p.load(fr);
        Set<String>key1=p.stringPropertyNames();
        for (String s : key1) {
            System.out.println(s+"="+p.getProperty(s));
        }
    }
}
