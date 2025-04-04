package skillnest.example.webflux.api.employee;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.domain.employee.EmployeeDto;

public interface IEmployeeController {

    @PostMapping
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto);
}
