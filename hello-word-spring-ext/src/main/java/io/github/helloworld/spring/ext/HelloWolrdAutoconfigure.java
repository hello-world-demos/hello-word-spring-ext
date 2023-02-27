package io.github.helloworld.spring.ext;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Import({
        MyBeanDefinitionRegistryPostProcessor.class,
        MyBeanDefinitionRegistryPostProcessor2.class,
        MyImportBeanDefinitionRegistrar.class,
        MyApplicationListener.class,
        DependedBean.class,
        MyApplicationRunner.class,
        MyCommandLineRunner.class
})
public class HelloWolrdAutoconfigure {


}
