package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Email;

/**
 * Mother for Email value objects.
 * Generates faker valid email addresses.
 */
public final class EmailMother {

    private EmailMother() {
    }

    public static Email random() {
        return new Email(FakerMother.faker().internet().emailAddress());
    }

    public static Email create(String value) {
        return new Email(value);
    }

}