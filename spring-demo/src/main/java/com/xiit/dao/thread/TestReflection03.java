package com.xiit.dao.thread;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection03 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.xiit.dao.thread.User");
        //无参
        User user = (User)c1.newInstance();
        System.out.println(user);

        //通过构造器创建对象
        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        Object user2 = constructor.newInstance("方", 10, 80);
        System.out.println(user2);

        User user3 = (User)c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "小方");
        System.out.println(user3.getName());


        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要通过关闭程序的安全属性setAccessible(true)
        name.setAccessible(true);
        name.set(user4,"小小方");
        System.out.println(user4.getName());


    }
}
