package skillnest.example.webflux.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.dto.EmployeeDto;

public interface IEmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String employeeId);
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId);
    Mono<Void> deleteEmployee(String employeeId);
}
