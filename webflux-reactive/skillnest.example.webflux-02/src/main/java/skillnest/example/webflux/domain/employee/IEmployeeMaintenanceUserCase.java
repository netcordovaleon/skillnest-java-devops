package skillnest.example.webflux.domain.employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeMaintenanceUserCase {

    Mono<EmployeeDto> save(EmployeeDto entity);
    Mono<EmployeeDto> getOne(String id);
    Flux<EmployeeDto> getAll();
    Mono<EmployeeDto> update(EmployeeDto entity, String id);
    Mono<Void> delete(String id);


}
