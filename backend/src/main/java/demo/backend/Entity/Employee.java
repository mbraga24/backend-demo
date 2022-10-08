package demo.backend.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
//@Table(name = "EMPLOYEE", schema = "DEPARTMENT")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="role")
    private String role;
    @Column(name="colors", length = 4000)
    private String colors;

    public Employee(String firstName, String lastName, String role, String colors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.colors = colors;
    }
}
