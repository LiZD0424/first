package MyIO;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\子东\\Desktop\\chong.txt");
        int a = 0;
        while ((a = fr.read()) != -1) {
            System.out.print((char) a);
        }
        fr.close();


        FileReader fr1 = null;
        try {
            fr1 = new FileReader("C:\\Users\\子东\\Desktop\\chong.txt");
            int n = 0;
            char[] c = new char[1024];
            while ((n = fr1.read(c)) != -1) {
                System.out.println(new String(c, 0, n));
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fr1 != null) {
                fr1.close();
            }
        }

        //jdk7 直接把定义卸载try后的括号里 不用关闭流
        try( FileReader fr2 = new FileReader("C:\\Users\\子东\\Desktop\\chong.txt");){
            int a1 = 0;
            while ((a1 = fr2.read()) != -1) {
                System.out.print((char) a1);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
