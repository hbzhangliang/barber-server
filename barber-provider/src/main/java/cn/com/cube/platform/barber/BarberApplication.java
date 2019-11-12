package cn.com.cube.platform.barber;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan("cn.com.cube.platform")
@SpringBootApplication
@MapperScan("cn.com.cube.platform.barber.mysql.mapper")
public class BarberApplication {

    public static void main(String[] args){
        SpringApplication springApplication = new SpringApplication(BarberApplication.class);
        springApplication.run(args);
    }

}
