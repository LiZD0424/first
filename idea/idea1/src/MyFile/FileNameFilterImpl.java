package MyFile;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterImpl implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {//dir,构造方法中传进来的目录 ，name 为使用ListFiles放法遍历目录获取的文件夹、文件名称
        File file=new File(dir,name);
        if(file.isDirectory())
            return true;
        return file.getName().endsWith(".txt");
    }
}
