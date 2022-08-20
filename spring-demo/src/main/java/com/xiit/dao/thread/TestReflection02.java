package com.xiit.dao.thread;

import java.lang.annotation.ElementType;

public class TestReflection02 {
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<String> stringClass = String.class;
        Class<int[]> aClass = int[].class;
        Class<Override> overrideClass = Override.class;
        Class<ElementType> elementTypeClass = ElementType.class;
        Class<Integer> integerClass = Integer.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;

        System.out.println(objectClass);
        System.out.println(comparableClass);
        System.out.println(stringClass);
        System.out.println(aClass);
        System.out.println(overrideClass);
        System.out.println(elementTypeClass);
        System.out.println(integerClass);
        System.out.println(voidClass);
        System.out.println(classClass);


        int[] ints = new int[10];
        int[] ints1 = new int[100];
        System.out.println(ints.getClass().hashCode());
        System.out.println(ints1.getClass().hashCode());


    }
}
