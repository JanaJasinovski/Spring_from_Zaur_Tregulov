package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        Pet pet = new Dog();

        Pet pet = context.getBean("myPet", Pet.class);
        Person person = new Person(pet);
        person.callYourPet();

        context.close();
    }
}
