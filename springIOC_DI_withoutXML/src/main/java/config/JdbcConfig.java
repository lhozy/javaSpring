package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
@PropertySource("classpath:jdbcConfig.properties") //加载数据库连接信息的properties配置文件
public class JdbcConfig {

    @Value("${jdbc.driver}") //注意SPeL表达式 ${...} 获取properties配置文件的值
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean("queryRunner") //不写名字，默认的是方法名称，
                            // 该标签的作用是将方法的返回值类型加入spring的容器中，
                            // 就如xml中的bean标签
    @Scope("prototype") //单例singleton多例prototype
    public QueryRunner createQueryRunner(@Qualifier("dataSource1") DataSource dataSource){
                                            //@Qualifier可以单独用在参数上，
                                            // 指定注入的参数dataSource类型为dataSource2
        return new QueryRunner(dataSource);
    }
    @Bean("dataSource1")
    public DataSource getDataSource2(){//数据源2：myspring数据库
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Bean("dataSource2")
    public DataSource getDataSource(){//数据源1：myspringdb数据库
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myspringdb");
            dataSource.setUser(user);
            dataSource.setPassword(password);
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
