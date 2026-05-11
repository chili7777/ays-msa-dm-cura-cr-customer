package com.pichincha.dm.cura.customer.shared.objectmothers;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerUpdateRequestDto;

public final class CustomerUpdateRequestDtoMother {

    private CustomerUpdateRequestDtoMother() {
    }

    public static CustomerUpdateRequestDto random() {
        return create(
                FakerMother.faker().name().fullName(),
                FakerMother.faker().options().option(CustomerUpdateRequestDto.GenderEnum.values()),
                FakerMother.faker().number().numberBetween(18, 99),
                FakerMother.faker().idNumber().valid(),
                FakerMother.faker().address().fullAddress(),
                FakerMother.faker().phoneNumber().phoneNumber(),
                FakerMother.faker().internet().emailAddress(),
                FakerMother.faker().internet().password(),
                FakerMother.faker().bool().bool()
        );
    }

    public static CustomerUpdateRequestDto create(String name,
                                                   CustomerUpdateRequestDto.GenderEnum gender,
                                                   Integer age,
                                                   String identification,
                                                   String address,
                                                   String phone,
                                                   String email,
                                                   String password,
                                                   Boolean status) {
        return new CustomerUpdateRequestDto(name, gender, age, identification, address, phone, email, password, status);
    }
}