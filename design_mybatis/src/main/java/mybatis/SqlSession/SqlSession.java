package mybatis.SqlSession;

/**
 * 自定义的可以与数据库交互的核心接口，里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);
    void close();
}
