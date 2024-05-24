package my.dev.co;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * Hello world!
 *
 */

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
         EntityManager em = emf.createEntityManager();
        ) {

/*
           em.getTransaction().begin();
            Employee emp = new Employee(158);
            emp.setName("tdddest");
            em.persist(emp);
            em.getTransaction().commit();
*/


            EmployeeService service = new EmployeeService(em);
// create and persist an employee
            em.getTransaction().begin();
            Employee emp = service.createEmployee(158, "John Doe", 45000);
            em.getTransaction().commit();
            System.out.println("Persisted " + emp);
// find a specific employee
            emp = service.findEmployee(158);
            System.out.println("Found " + emp);
// find all employees
            List<Employee> emps = service.findAllEmployees();
            for (Employee e : emps)
                System.out.println("Found employee: " + e);
// update the employee
            em.getTransaction().begin();
            emp = service.raiseEmployeeSalary(158, 1000);
            em.getTransaction().commit();
            System.out.println("Updated " + emp);
// remove an employee
/*            em.getTransaction().begin();
            service.removeEmployee(158);
            em.getTransaction().commit();
            System.out.println("Removed Employee 158");*/


        }


    }
}
