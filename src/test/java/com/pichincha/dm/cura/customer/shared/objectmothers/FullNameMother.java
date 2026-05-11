package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.FullName;

/**
 * Mother for FullName value objects.
 * Generates random person names using data faker.
 */
public final class FullNameMother {

    private FullNameMother() {
    }

    public static FullName random() {
        return new FullName(FakerMother.random().name().fullName());
    }

    public static FullName create(String value) {
        return new FullName(value);
    }

}