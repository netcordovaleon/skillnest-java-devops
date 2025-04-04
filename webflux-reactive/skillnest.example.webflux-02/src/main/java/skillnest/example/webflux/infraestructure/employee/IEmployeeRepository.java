package skillnest.example.webflux.infraestructure.employee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import skillnest.example.webflux.domain.employee.Employee;

public interface IEmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
