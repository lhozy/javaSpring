package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan("com.lhozy")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
