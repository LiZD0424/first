package MyFile;

import java.io.File;
import java.io.IOException;

/*
 * 操作路径不能写死了
 * "c:\xxx\xxx"
 * 应该写成
 * "c:"+File.separator+"xxx"+File.separator+"xxx"
 * 绝对路径
 * 以盘符开始的路径 c:\\demo\\a.txt
 * 相对路径
 * 相对指的是相对于当前项目的根目录，如c:\\demo
 * 如果使用当前项目的根目录，路径可以简化书写
 * c:\\demo\\a.txt若当前在c:\\demo，可简化为a.txt（省略了项目的根目录）
 * 路径不区分大小写
 * */
public class MyFile {
    public static void main(String[] args) throws IOException {
        String p1 = File.pathSeparator;//与系统有关的路径分隔符 win ；linux ：
        char c1 = File.pathSeparatorChar;
        System.out.println(p1);
        System.out.println(c1);
        String p2 = File.separator;//与系统有关的默认名称分隔符  win \  linux /
        char c2 = File.separatorChar;
        System.out.println(p2);
        System.out.println(c2);
        File f1 = new File("C:\\Users\\子东\\Desktop");//可以是绝对路径也能是相对路径，创建对象的时候不检查文件真实性，路径可以是存在的也可以是不存在的，可以是文件结尾也可以是文件夹结尾
        File f2 = new File("c:\\", "demo");//父子路径分开写。很灵活
        File f3 = new File(f1, "\\a.txt");//父对象是定义好的file类对象，可以先做一些运算
        File f4 = new File("b.txt");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        String f1AbsolutePath = f1.getAbsolutePath();//返回文件的绝对路径
        String f2Path = f4.getPath();//返回路径创建时是绝对的，返回就是绝对的 相对的就是相对的路径
        String f1Name = f1.getName();//名称
        Long f1Length = f1.length();//长度，不能返回文件夹大小返回0，若路径文件不存在返回0
        System.out.println("绝对路径" + f1AbsolutePath);
        System.out.println(f2Path);
        System.out.println(f1Name);
        System.out.println(f1Length);
        System.out.println(f1.exists());//是否存在
        System.out.println(f1.isFile());//是否是文件
        System.out.println(f1.isDirectory());//是否是文件夹
        File f5 = new File("C:\\Users\\子东\\Desktop\\ccc.txt");
        boolean b1 = f5.createNewFile();
        System.out.println("b1" + b1);//根据File路径创建文件（不能创建文件夹） 路径必须存在，否则抛出异常，若文件以创建饭后false
        File f6 = new File("C:\\Users\\子东\\Desktop\\ssss.txt");
        boolean b2 = f6.mkdir();//创建文件夹，路径名不存在不会抛异常。返回false，文件夹已存在返回false
        System.out.println("b2" + b2);
        File f7 = new File("C:\\Users\\子东\\Desktop\\111\\222\\333");//创建多级文件夹
        boolean b3 = f7.mkdirs();
        System.out.println("b3" + b3);
        boolean b4 = f7.delete();//成功删除返回true，删除失败返回false，不走回收站
        System.out.println("b4" + b4);
        String[] str = f1.list();//遍历文件夹 若f1不是文件夹则抛出空指针异常，若f1路经不存在也会抛出空指针异常,String只打印文件名，会显示隐藏文件夹
        for (String s : str) {
            System.out.println(s);
        }
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println("files" + file);
        }
        /*
         * 过滤器
         * */
        getALLFile(f1);
        getALLFile1(f1);
    }

    private static void getALLFile1(File f1) {
        File[] files = f1.listFiles(new FileNameFilterImpl());
        for (File file : files) {
            if (file.isDirectory()) {
                getALLFile(file);
            } else {
                System.out.println(file);
            }

        }
    }

    private static void getALLFile(File f1) {
        File[] files = f1.listFiles(new FileFilterImpl());
        /* listFiles做了三件事：
         * 1.listFiles将构造方法中的目录进行遍历，获取目录中的每一个文件、文件夹，然后封装成File对象
         * 2.调用参数FileFilter过滤器接口的实现类对象中的accept方法
         * 3.把遍历得到的每一个File对象作为参数pathname传递给accept方法
         * */
        for (File file : files) {
            if (file.isDirectory()) {
                getALLFile(file);
            } else {
                System.out.println(file);
            }

        }
    }
}
