package domain.company.entity;

import domain.shared.StringValueObject;

public final class CompanyName extends StringValueObject {
    public CompanyName(String value) {
        super(value);
    }

    private CompanyName() {
        super("");
    }
}
