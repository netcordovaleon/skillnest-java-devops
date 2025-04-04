package domain.company.events;

import domain.shared.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class CompanyCreatedDomainEvent extends DomainEvent {

    private final String name;

    public CompanyCreatedDomainEvent(String aggregateId, String name) {
        super(aggregateId);
        this.name = name;
    }

    public CompanyCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String name
    ) {
        super(aggregateId, eventId);

        this.name     = name;
    }

    @Override
    public String eventName() {
        return "company.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }

    @Override
    public CompanyCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId) {
        return new CompanyCreatedDomainEvent(
                aggregateId,
                eventId,
                (String) body.get("name")
        );
    }
}
