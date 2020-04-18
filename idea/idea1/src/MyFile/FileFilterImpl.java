package MyFile;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {//若返回值为true，则会把此对象放在File数组中，若返回值为false，则不会把此对象放在File数组中
        if (pathname.isDirectory())//如果是文件夹则返回true，为了继续遍历文件夹里的内容，否则当文件夹不是以.txt结尾命名时将不会继续检查其内部文件
            return true;
        return pathname.getName().endsWith(".txt");
}
}
