package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration //表示该类是一个spring配置类
@ComponentScan("com.lhozy") //要扫描的包路径
@Import(JdbcConfig.class)
//@PropertySource("classpath:jdbcConfig.properties") //加载数据库连接信息的properties配置文件
public class SpringConfiguration {

}
