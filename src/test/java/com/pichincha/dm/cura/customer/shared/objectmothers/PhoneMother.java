package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Phone;

/**
 * Mother for Phone value objects.
 * Generates faker phone numbers.
 */
public final class PhoneMother {

    private PhoneMother() {
    }

    public static Phone random() {
        return new Phone(FakerMother.faker().phoneNumber().cellPhone());
    }

    public static Phone create(String value) {
        return new Phone(value);
    }

}