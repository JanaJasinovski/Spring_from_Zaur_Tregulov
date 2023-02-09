package org.example;

import aop.MyConfig;
import aop.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = uniLibrary.returnBook();
        System.out.println("В библиотеку вернули книгу: " + bookName);

        context.close();
        System.out.println("Method main ends");
    }
}
