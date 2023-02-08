package org.example;

import aop.Book;
import aop.SchoolLibrary;
import aop.UniLibrary;
import aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
//        uniLibrary.getBook("Преступление и название");
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook(book);
        uniLibrary.returnBook();
        uniLibrary.getMagazine();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        context.close();
    }
}
