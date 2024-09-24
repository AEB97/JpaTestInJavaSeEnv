package my.dev.co;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProjectService {
    protected EntityManager em;
    public ProjectService(EntityManager em) {
        this.em = em;
    }
    public Project createProject(String name) {
        Project emp = new Project();
        emp.setName(name);
        em.persist(emp);
        return emp;
    }

    public void removeProject(int id) {
        Project emp = findProject(id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Project findProject(int id) {
        return em.find(Project.class, id);
    }
    public List<Project> findAllProjects() {
        TypedQuery<Project> query = em.createQuery(
                "SELECT e FROM Employee e", Project.class);
        return query.getResultList();
    }



}