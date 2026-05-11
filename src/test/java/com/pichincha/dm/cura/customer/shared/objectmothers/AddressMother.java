package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Address;

/**
 * Mother for Address value objects.
 * Generates random physical addresses.
 */
public final class AddressMother {

    private AddressMother() {
    }

    public static Address random() {
        return new Address(FakerMother.random().address().fullAddress());
    }

    public static Address create(String value) {
        return new Address(value);
    }

}