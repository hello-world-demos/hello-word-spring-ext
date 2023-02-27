package io.github.helloworld.spring.ext;

public class RegisterBean {

    private DependedBean dependedBean;
    private String value;

    public RegisterBean() {
        System.out.println("RegisterBean 创建");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DependedBean getDependedBean() {
        return dependedBean;
    }

    public void setDependedBean(DependedBean dependedBean) {
        this.dependedBean = dependedBean;
    }


    @Override
    public String toString() {
        return "RegisterBean{" +
                "dependedBean=" + dependedBean +
                ", value='" + value + '\'' +
                '}';
    }
}
