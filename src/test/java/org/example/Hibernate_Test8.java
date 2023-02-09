package org.example;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Test8 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Yana", "Yasinovski", 800);
//            Employee employee2 = new Employee("Denis", "Teterukov", 100_000);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();

//            session.save(department);

            Department department = session.get(Department.class, 1);
//            System.out.println(department);
            System.out.println(department.getEmployees());

            session.delete(department);

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }

    }
}
