package my.dev.co;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;

    @ManyToMany
    private Collection<Project> projects;

    @OneToOne
    @JoinColumn(name="PSPACE_ID")
    private ParkingSpace parkingSpace;

    @Embedded
    private Address address;
    @ElementCollection
    private Set<String> nickNames;

    public Employee() {
        projects = new ArrayList<>();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void addProject(Project project) {
        if (!getProjects().contains(project)) {
            getProjects().add(project);
        }
        if (!project.getEmployees().contains(this)) {
            project.getEmployees().add(this);
        }
    }

    public Collection<Project> getProjects() {
        return projects;
    }
    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Set<String> nickNames) {
        this.nickNames = nickNames;
    }

    public String toString() {
        return "Employee id: " + getId() + " name: " + getName() +
                " with " + getProjects().size() + " projects" + " with " + getParkingSpace() + " address: " + getAddress();
    }
}