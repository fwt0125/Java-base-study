package com.xiit.dao.thread;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class TestReflectionAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class aClass = Class.forName("com.xiit.dao.thread.ren");

        //反射获得指定害的注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        TableFWt tablefwt = (TableFWt) aClass.getAnnotation(TableFWt.class);
        String value = tablefwt.value();
        System.out.println(value);

        Field f = aClass.getDeclaredField("name");
        FieldFwt annotation = f.getAnnotation(FieldFwt.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }
}

@TableFWt("java_fwt")
class ren {
    @FieldFwt(columnName = "id", type = "int", length = 10)
    int id;
    @FieldFwt(columnName = "age", type = "int", length = 3)
    int age;
    @FieldFwt(columnName = "name", type = "varchar", length = 100)
    String name;

    public ren() {
    }

    public ren(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableFWt{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFwt{
    String columnName();
    String type();
    int length();
}