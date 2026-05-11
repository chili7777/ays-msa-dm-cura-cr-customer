package com.pichincha.dm.cura.customer.domain.entities.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Value object representing the operational status of a customer record.
 * Wraps a boolean value and provides helper methods to check if the customer is active.
 */
@EqualsAndHashCode
public class Status implements ValueObject<Boolean> {

    @Getter
    private final Boolean value;

    public Status(Boolean value) {
        ensureValidStatus(value);
        this.value = value;
    }

    private void ensureValidStatus(Boolean value) {
        if (value == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    public boolean isActive() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
