package skillnest.example.webflux.api.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import skillnest.example.webflux.domain.employee.EmployeeDto;
import skillnest.example.webflux.domain.employee.IEmployeeMaintenanceUserCase;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController implements IEmployeeController {

    @Autowired
    private IEmployeeMaintenanceUserCase _employeeUseCase;

    @GetMapping("{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String employeeId){
        return _employeeUseCase.getOne(employeeId);
    }

    @GetMapping
    public Flux<EmployeeDto> getAllEmployees(){
        return _employeeUseCase.getAll();
    }

    @PutMapping("{id}")
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                            @PathVariable("id") String employeeId){
        return _employeeUseCase.update(employeeDto, employeeId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId){
        return _employeeUseCase.delete(employeeId);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        return _employeeUseCase.save(employeeDto);    }
}
