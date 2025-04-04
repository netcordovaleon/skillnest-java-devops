package domain.company.entity;

import domain.company.events.CompanyCreatedDomainEvent;
import domain.shared.AggregateRoot;

public final class Company extends AggregateRoot {



    private final CompanyId id;
    private final CompanyName name;


    public Company(CompanyId id, CompanyName name) {
        this.id = id;
        this.name = name;
    }

    public Company() {
        this.id = null;
        this.name = null;
    }

    public static Company create(CompanyId id, CompanyName name) {
        Company company = new Company(id, name);
        company.record(new CompanyCreatedDomainEvent(id.value(), name.value()));
        return company;
    }


}
