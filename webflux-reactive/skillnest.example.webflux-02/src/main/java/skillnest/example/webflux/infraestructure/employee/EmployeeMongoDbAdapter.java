package skillnest.example.webflux.infraestructure.employee;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.domain.employee.Employee;
import skillnest.example.webflux.domain.employee.IEmployeePersistencePort;

public class EmployeeMongoDbAdapter implements IEmployeePersistencePort {

    @Autowired
    private IEmployeeRepository _employeeRepository;

    @Override
    public Mono<Employee> save(Employee entity) {
        return _employeeRepository.save(entity);

    }

    @Override
    public Mono<Employee> getOne(String id) {
        return _employeeRepository.findById(id);
    }

    @Override
    public Flux<Employee> getAll() {
        return _employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> update(Employee entity, String id) {
        Mono<Employee> employeeMono = _employeeRepository.findById(id);
        return employeeMono.flatMap((existEmployee) -> {
            existEmployee.setFirstName(entity.getFirstName());
            existEmployee.setLastName(entity.getLastName());
            existEmployee.setEmail(entity.getEmail());
            return _employeeRepository.save(existEmployee);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return _employeeRepository.deleteById(id);
    }
}
