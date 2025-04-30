package pe.skillnest.webflux.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("api/nonblocking")
public class NonBlockingController {

    @GetMapping
    public Mono<String> getString() {
        return Mono.just("No bloqueante").delayElement(Duration.ofSeconds(10));

    }

}
