package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Address;

/**
 * Mother for Address value objects.
 * Generates faker physical addresses.
 */
public final class AddressMother {

    private AddressMother() {
    }

    public static Address random() {
        return new Address(FakerMother.faker().address().fullAddress());
    }

    public static Address create(String value) {
        return new Address(value);
    }

}