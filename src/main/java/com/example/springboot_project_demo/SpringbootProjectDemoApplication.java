package com.example.springboot_project_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.springboot_project_demo.model")
public class SpringbootProjectDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectDemoApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SingletonScopeConfiguration.class);
        context.register(PrototypeScopeConfiguration.class);
        context.refresh();

        SingletonScopeBean s1 = context.getBean(SingletonScopeBean.class);
        System.out.println(s1.hashCode());

        SingletonScopeBean s2 = context.getBean(SingletonScopeBean.class);
        System.out.println(s2.hashCode());

        PrototypeScopeBean p1 = context.getBean(PrototypeScopeBean.class);
        System.out.println(p1.hashCode());

        PrototypeScopeBean p2 = context.getBean(PrototypeScopeBean.class);
        System.out.println(p2.hashCode());

    }

}