package com.pichincha.dm.cura.customer.shared.objectmothers;

import java.util.UUID;

/**
 * Utility mother for generating random UUID strings.
 * Simplifies the creation of standardized UUIDs for various test scenarios.
 */
public final class UuidMother {

    private UuidMother() {
    }

    public static String random() {
        return UUID.randomUUID().toString();
    }

}