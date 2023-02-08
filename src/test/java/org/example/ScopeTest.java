package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog dog1 = context.getBean("dog", Dog.class);
        Dog dog2 = context.getBean("dog", Dog.class);

        System.out.println("Переменные ссылаются на один и тот же объект? " + (dog1 == dog2));
        System.out.println(dog1);
        System.out.println(dog2);

        dog1.say();

        context.close();
    }
}
