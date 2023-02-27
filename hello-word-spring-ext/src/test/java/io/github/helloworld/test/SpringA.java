package io.github.helloworld.test;

import io.github.helloworld.spring.ext.RegisterBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringA {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringA.class, args);

        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext)run;
        List<BeanFactoryPostProcessor> beanFactoryPostProcessors = context.getBeanFactoryPostProcessors();
        System.out.println(beanFactoryPostProcessors);
        System.out.println(context.getBean(RegisterBean.class));

    }
}
