package org.spring.boot.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.spring.boot.app.*")
@EnableAspectJAutoProxy
public class BeanConfiguration {

}
