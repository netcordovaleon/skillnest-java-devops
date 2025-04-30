package pe.skillnest.webflux.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blocking")
public class BlockingController {

    @GetMapping
    public String getString() throws InterruptedException {
        Thread.sleep(10000);
        return "Proceso bloqueante";
    }

}
