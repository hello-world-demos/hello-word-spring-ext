package io.github.helloworld.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanDefinitionRegistryPostProcessor2
        implements BeanDefinitionRegistryPostProcessor, Ordered {

    private BeanDefinitionRegistry registry;
    // 不生效
//    @Autowired
//    private DependedBean dependedBean;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor2.postProcessBeanDefinitionRegistry");
        this.registry = beanDefinitionRegistry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 所有的bean都已经注册但是 context还未 refresh
        System.out.println("BeanDefinitionRegistryPostProcessor2.postProcessBeanFactory");
        AbstractBeanDefinition value = BeanDefinitionBuilder.rootBeanDefinition(RegisterBean.class)
                .addPropertyValue("value", "123")
                // 可以注入进去
//                .addAutowiredProperty("dependedBean")
                // 字段注入不生效
//                .addPropertyValue("dependedBean", dependedBean)
                // DependedBean 提前初始化, 在 getBean 动作发生的时候
                .addPropertyValue("dependedBean", configurableListableBeanFactory.getBean(DependedBean.class))
                .getBeanDefinition();
        registry.registerBeanDefinition("isCanRegister", value);

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
