package mybatis.SqlSession;

import mybatis.SqlSession.defaults.DefaultSqlSessionFactory;
import mybatis.cfg.Configuration;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * y用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(cfg);
    }
}
