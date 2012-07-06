package org.jboss.as.quickstarts.servlet;

import java.io.Serializable;

public class MyResource implements Serializable {

    private static final long serialVersionUID = 7999484626622316972L;

    private final String name;
    
    public MyResource(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "MyResource[name=" + name + "]";
    }
}