package my.dev.co;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

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
//
//
//
//
//
//
//
//
//
//
//
//            em.getTransaction().begin();
//
//            EmployeeService empSrvs = new EmployeeService(em);
//
//            Employee employee = empSrvs.createEmployee("emp one", 1200);
//
//            employee.setAddress(new Address("street","cityy","sate","zipcode"));
//
//            Set<String> stringSet = new HashSet<>();
//            stringSet.add("ali");
//            stringSet.add("ali");
//            stringSet.add("mmd");
//            stringSet.add("reza");
//
//
//            employee.setNickNames(stringSet);
//
//            ParkingSpace parkingSpace = new ParkingSpace();
//            em.persist(parkingSpace);
//
//            parkingSpace.setLocation("depName");
//            parkingSpace.setLot(1);
//            parkingSpace.setEmployee(employee);
//
//            employee.setParkingSpace(parkingSpace);
//
//
//            Project project = new Project();
//            em.persist(project);
//
//            project.setName("project one");
//
//            project.addEmployee(employee);
//
//            Project project2 = new Project();
//            em.persist(project2);
//
//            project2.setName("project two");
//
//          employee.addProject(project2);
//
//
//
//
//
//
//
//
//
//
//
//
//
//            em.getTransaction().commit();
//



/*
            EmployeeService empSrvs = new EmployeeService(em);
            Employee employee = empSrvs.findEmployee(1);

            System.out.println(employee==null);
            List<Employee> allEmployees = empSrvs.findAllEmployees();
            System.out.println(allEmployees);



            Employee employee2 = empSrvs.findEmployee(1);
            System.out.println(employee2==null);


            System.out.println( employee.getAddress());
            System.out.println(employee.getId());
            System.out.println(employee.getName());
            System.out.println(employee.getSalary());
            System.out.println(employee.getNickNames());
            System.out.println(employee.getParkingSpace());
            System.out.println(employee.getProjects());

            System.out.println("ddddddddddddddddd");
            System.out.println(employee);
*/

            EmployeeService empSrvs = new EmployeeService(em);
            Employee employee = empSrvs.findEmployee(1);

            Collection<Project> projects = employee.getProjects();

            Iterator<Project> iterator = projects.iterator();

            while (iterator.hasNext()){

                Project next = iterator.next();

                System.out.println(next);


            }





            /*
*//*
           em.getTransaction().begin();
            Employee emp = new Employee(158);
            emp.setName("tdddest");
            em.persist(emp);
            em.getTransaction().commit();
*//*


            EmployeeService service = new EmployeeService(em);
// create and persist an employee
            em.getTransaction().begin();
            Employee emp = service.createEmployee( "John Doe", 45000);
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
*//*            em.getTransaction().begin();
            emp = service.raiseEmployeeSalary(158, 1000);
            em.getTransaction().commit();
            System.out.println("Updated " + emp);*//*
// remove an employee
*//*            em.getTransaction().begin();
            service.removeEmployee(158);
            em.getTransaction().commit();
            System.out.println("Removed Employee 158");*//*



            ProjectService projectService = new ProjectService(em);

            em.getTransaction().begin();
            Project p = projectService.createProject( "mmd");
            Project p1 = projectService.createProject( "mmd1");
            em.getTransaction().commit();
            System.out.println("Persisted " + p);



            em.getTransaction().begin();
            service.addEmployeeProject(1,1);
            emp = service.findEmployee(1);
            p1.addEmployee(emp);
            em.getTransaction().commit();


            System.out.println(projectService.findProject(1));
            System.out.println(service.findEmployee(1));

            Project p2 = projectService.createProject( "mmd3");
            System.out.println(p2);

            Employee employee = service.findEmployee(1);
            System.out.println(employee.getProjects().size());

            employee.getProjects().forEach(System.out::println);

            em.getTransaction().begin();
            System.out.println("htere");
            Employee employddee = service.findEmployee(1);
            System.out.println("heree");
            em.getTransaction().commit();





        */

        }


    }
}
