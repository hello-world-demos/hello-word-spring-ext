package io.github.helloworld.spring.ext;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

@Order(21123)
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 比 BeanDefinitionRegistryPostProcessor 先执行
        System.out.println("MyImportBeanDefinitionRegistrar 注解信息"+importingClassMetadata);
    }

}
