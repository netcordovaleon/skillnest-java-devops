package skillnest.example.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import skillnest.example.webflux.domain.Employee;

public interface IEmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
