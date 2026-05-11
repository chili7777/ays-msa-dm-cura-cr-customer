package com.pichincha.dm.cura.customer.shared.objectmothers;

import net.datafaker.Faker;

/**
 * Provides a centralized instance of the data generation library.
 * Ensures consistent configuration for all random data generators used in tests.
 */
public final class FakerMother {

    private static final Faker FAKER = new Faker();

    private FakerMother() {
    }

    public static Faker random() {
        return FAKER;
    }

}