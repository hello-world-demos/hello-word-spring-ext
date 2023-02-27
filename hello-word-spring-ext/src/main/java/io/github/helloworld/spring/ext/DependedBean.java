package io.github.helloworld.spring.ext;

import org.springframework.stereotype.Service;

@Service
public class DependedBean {


    public DependedBean() {
        System.out.println("DependedBean 创建");
    }

    @Override
    public String toString() {
        return "这是 DependedBean{}";
    }
}
