package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.identifiers.CustomerId;
import java.util.UUID;

/**
 * Mother for CustomerId value objects.
 * Generates faker UUID-based identifiers for testing customer identity.
 */
public final class CustomerIdMother {

    private CustomerIdMother() {
    }

    public static CustomerId random() {
        return new CustomerId(UUID.randomUUID().toString());
    }

    public static CustomerId create(String value) {
        return new CustomerId(value);
    }

    public static CustomerId create(UUID value) {
        return new CustomerId(value.toString());
    }

}