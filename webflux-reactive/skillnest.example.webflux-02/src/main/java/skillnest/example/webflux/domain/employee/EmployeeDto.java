package skillnest.example.webflux.domain.employee;

import lombok.*;


@Builder
public class EmployeeDto {

    public EmployeeDto(String id, String email, String lastName, String firstName) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    private String id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;
    private String lastName;
    private String email;
}
