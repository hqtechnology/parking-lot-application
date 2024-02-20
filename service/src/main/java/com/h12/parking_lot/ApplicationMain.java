package com.h12.parking_lot;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
@Configuration
public class ApplicationMain {
    /**
     * Main function.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //SpringApplication.run(ApplicationMain.class, args);
        SpringApplication application = new SpringApplication(ApplicationMain.class);
        //application.setWebEnvironment(false);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    //    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
