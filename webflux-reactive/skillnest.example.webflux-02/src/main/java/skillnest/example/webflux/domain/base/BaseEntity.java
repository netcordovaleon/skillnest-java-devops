package skillnest.example.webflux.domain.base;

import org.springframework.data.annotation.Id;

public class BaseEntity {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

}
