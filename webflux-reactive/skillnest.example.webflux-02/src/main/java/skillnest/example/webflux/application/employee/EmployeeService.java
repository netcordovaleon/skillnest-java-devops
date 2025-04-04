package skillnest.example.webflux.application.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.domain.employee.Employee;
import skillnest.example.webflux.domain.employee.EmployeeDto;
import skillnest.example.webflux.domain.employee.IEmployeeMaintenanceUserCase;
import skillnest.example.webflux.domain.employee.IEmployeePersistencePort;
import skillnest.example.webflux.application.employee.mapper.EmployeeMapper;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeMaintenanceUserCase {

    @Autowired
    private IEmployeePersistencePort _employeePersistencePort;

    @Override
    public Mono<EmployeeDto> save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = _employeePersistencePort.save(employee);
        return savedEmployee
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));    }

    @Override
    public Mono<EmployeeDto> getOne(String employeeId) {
        Mono<Employee> employeeMono = _employeePersistencePort.getOne(employeeId);
        return employeeMono.map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));    }

    @Override
    public Flux<EmployeeDto> getAll() {
        Flux<Employee> employeeFlux  = _employeePersistencePort.getAll();
        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());    }

    @Override
    public Mono<EmployeeDto> update(EmployeeDto employeeDto, String employeeId) {
        Mono<Employee> employeeMono = _employeePersistencePort.getOne(employeeId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            //existingEmployee.setEmail(employeeDto.getEmail());
            return _employeePersistencePort.save(existingEmployee);
        }).map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));
    }

    @Override
    public Mono<Void> delete(String id) {
        return _employeePersistencePort.delete(id);
    }
}
