package domain.company.exceptions;

import domain.company.entity.CompanyId;
import domain.shared.DomainException;

public final class CompanyDoesntExist extends DomainException {
    public CompanyDoesntExist(CompanyId id) {
        super("company_doesnt_exists", String.format("The course <%s> doesn't exist", id.value()));
    }
}
