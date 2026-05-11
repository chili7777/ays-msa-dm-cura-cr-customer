package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;

/**
 * Mother for CustomerCreateRequestDto objects.
 * Generates realistic request DTOs for testing the controller layer and mapping logic.
 */
public final class CustomerCreateRequestDtoMother {

    private CustomerCreateRequestDtoMother() {
    }

    public static CustomerCreateRequestDto random() {
        CustomerCreateRequestDto dto = new CustomerCreateRequestDto();
        dto.setIdentification(IdentificationMother.random().getValue());
        dto.setFullName(FullNameMother.random().getValue());
        dto.setEmail(EmailMother.random().getValue());
        dto.setPhone(PhoneMother.random().getValue());
        dto.setAddress(AddressMother.random().getValue());
        dto.setStatus(StatusMother.random().getValue());
        return dto;
    }

}