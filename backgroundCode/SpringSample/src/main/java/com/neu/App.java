package com.neu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *启动类
 */
@SpringBootApplication
@MapperScan(basePackages="com.neu.dao")
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
       // System.out.println( "Hello World!" );
        System.out.println( "该服务名称是：{}"+context.getEnvironment().getProperty("spring.application.name") );
        System.out.println( "该服务启动端口是：{}"+context.getEnvironment().getProperty("server.port") );
    }
}
