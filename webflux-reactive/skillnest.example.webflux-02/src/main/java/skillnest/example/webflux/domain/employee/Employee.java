package skillnest.example.webflux.domain.employee;

import org.springframework.data.mongodb.core.mapping.Document;
import skillnest.example.webflux.domain.base.BaseEntity;


@Document(value = "employees")
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String id, String firstName, String email, String lastName) {
        this.setId(id);
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
