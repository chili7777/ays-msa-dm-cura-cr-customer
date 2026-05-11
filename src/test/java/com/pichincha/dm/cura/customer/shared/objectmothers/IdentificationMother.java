package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Identification;

/**
 * Mother for Identification value objects.
 * Generates faker but realistic identification numbers for testing purposes.
 */
public final class IdentificationMother {

    private IdentificationMother() {
    }

    public static Identification random() {
        return new Identification(FakerMother.faker().idNumber().valid());
    }

    public static Identification create(String value) {
        return new Identification(value);
    }

}