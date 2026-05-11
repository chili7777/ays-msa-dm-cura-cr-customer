package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;

public final class CustomerCreateRequestDtoMother {

    private CustomerCreateRequestDtoMother() {
    }

    public static CustomerCreateRequestDto random() {
        return create(
                FakerMother.faker().name().fullName(),
                FakerMother.faker().options().option(CustomerCreateRequestDto.GenderEnum.values()),
                FakerMother.faker().number().numberBetween(18, 99),
                FakerMother.faker().idNumber().valid(),
                FakerMother.faker().address().fullAddress(),
                FakerMother.faker().phoneNumber().phoneNumber(),
                FakerMother.faker().internet().emailAddress(),
                FakerMother.faker().internet().password(),
                FakerMother.faker().bool().bool()
        );
    }

    public static CustomerCreateRequestDto create(String name,
                                                   CustomerCreateRequestDto.GenderEnum gender,
                                                   Integer age,
                                                   String identification,
                                                   String address,
                                                   String phone,
                                                   String email,
                                                   String password,
                                                   Boolean status) {
        return new CustomerCreateRequestDto(name, gender, age, identification, address, phone, email, password, status);
    }
}