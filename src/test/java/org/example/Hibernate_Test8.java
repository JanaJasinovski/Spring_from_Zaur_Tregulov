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
//            Department department = new Department("Sales", 800, 1500);
//            Employee employee1 = new Employee("Yana", "Yasinovski", 800);
//            Employee employee2 = new Employee("Denis", "Teterukov", 100_000);
//            Employee employee3 = new Employee("Julia", "Kravchinskaya", 1200);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);

            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 1);

            System.out.println("Get department");
            System.out.println(department);

            System.out.println("Подгрузим наших оаботников");
            department.getEmployees().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmployees());
//            session.save(department);


            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }

    }
}
