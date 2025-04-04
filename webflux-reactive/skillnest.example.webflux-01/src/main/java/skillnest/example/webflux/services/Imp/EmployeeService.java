package skillnest.example.webflux.services.Imp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.domain.Employee;
import skillnest.example.webflux.dto.EmployeeDto;
import skillnest.example.webflux.mapper.EmployeeMapper;
import skillnest.example.webflux.repository.IEmployeeRepository;
import skillnest.example.webflux.services.IEmployeeService;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);
        return employeeMono.map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employeeFlux  = employeeRepository.findAll();
        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            //existingEmployee.setEmail(employeeDto.getEmail());
            return employeeRepository.save(existingEmployee);
        }).map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
