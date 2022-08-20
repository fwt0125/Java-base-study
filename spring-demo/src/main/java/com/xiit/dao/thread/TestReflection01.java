package com.xiit.dao.thread;

public class TestReflection01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Student person = new Student();
        System.out.println("这个人是"+person.name);

        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("com.xiit.dao.thread.Student");
        System.out.println(c2.hashCode());

        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        Class superclass = c1.getSuperclass();
        System.out.println(superclass);



    }
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}
