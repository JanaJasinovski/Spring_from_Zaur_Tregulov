package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet dog = context.getBean("myPet", Pet.class);
        dog.say();

        context.close();
    }
}
