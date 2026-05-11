package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerPatchRequestDto;

public final class CustomerPatchRequestDtoMother {

    private CustomerPatchRequestDtoMother() {
    }

    public static CustomerPatchRequestDto random() {
        CustomerPatchRequestDto dto = new CustomerPatchRequestDto();
        dto.setName(FakerMother.faker().name().fullName());
        dto.setPhone(FakerMother.faker().phoneNumber().phoneNumber());
        return dto;
    }
}