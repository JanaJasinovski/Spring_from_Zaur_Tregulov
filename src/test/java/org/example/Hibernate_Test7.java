package org.example;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Test7 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

//            Employee employee = new Employee("Nikolai", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New-York", "23423423423", "Nikolai@gmail.com");
//
//            employee.setDetail(detail);
//            detail.setEmployee(employee);
//
//            session.save(detail);

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setDetail(null);

//            System.out.println(detail.getEmployee());

            session.delete(detail);

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }

    }
}
