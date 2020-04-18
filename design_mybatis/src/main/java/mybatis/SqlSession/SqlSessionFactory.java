package mybatis.SqlSession;

public interface SqlSessionFactory {
    /**
     * 用于返回SqlSession接口对象
     * @return SqlSession接口对象
     */
    SqlSession openSession();
}
