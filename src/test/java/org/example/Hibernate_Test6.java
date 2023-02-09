package org.example;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Test6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//
//            Employee employee = new Employee("Yana", "Yasinovski", "IT", 500);
//            Detail detail = new Detail("Baku", "123456789", "jantisch3@gmail.com");
//
//            employee.setDetail(detail);
            session.beginTransaction();
//
//            session.save(employee);


//            Employee employee = new Employee("Oleg", "Smirnow", "Sales", 700);
//            Detail detail = new Detail("Moscow", "234534534", "Oleg@gmail.com");
//
//            employee.setDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);


//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee.getDetail());


            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();

            System.out.println("Done");


        } finally {
            session.close();
            factory.close();
        }

    }
}
