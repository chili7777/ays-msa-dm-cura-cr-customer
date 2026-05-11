package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.domain.entities.valueobjects.Status;

/**
 * Mother for Status value objects.
 * Generates random boolean status values.
 */
public final class StatusMother {

    private StatusMother() {
    }

    public static Status random() {
        return new Status(FakerMother.random().bool().bool());
    }

    public static Status active() {
        return new Status(true);
    }

    public static Status inactive() {
        return new Status(false);
    }

}