package mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器获取字节输入流
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
