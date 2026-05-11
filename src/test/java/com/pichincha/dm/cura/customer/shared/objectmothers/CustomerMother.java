package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.entities.identifiers.CustomerId;
import com.pichincha.dm.cura.customer.domain.entities.valueobjects.*;

/**
 * Mother for Customer domain entities.
 * Coordinates multiple value object mothers to build complete and valid Customer instances
 * with randomized or specific attribute values.
 */
public final class CustomerMother {

    private CustomerMother() {
    }

    public static Customer random() {
        return new Customer(
                CustomerIdMother.random(),
                IdentificationMother.random(),
                FullNameMother.random(),
                EmailMother.random(),
                PhoneMother.random(),
                AddressMother.random(),
                StatusMother.random()
        );
    }

    public static Customer randomWithId(CustomerId id) {
        return new Customer(
                id,
                IdentificationMother.random(),
                FullNameMother.random(),
                EmailMother.random(),
                PhoneMother.random(),
                AddressMother.random(),
                StatusMother.random()
        );
    }

}