package skillnest.example.webflux.domain.employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeePersistencePort {

    Mono<Employee> save(Employee entity);
    Mono<Employee> getOne(String id);
    Flux<Employee> getAll();
    Mono<Employee> update(Employee entity, String id);
    Mono<Void> delete(String id);

}
