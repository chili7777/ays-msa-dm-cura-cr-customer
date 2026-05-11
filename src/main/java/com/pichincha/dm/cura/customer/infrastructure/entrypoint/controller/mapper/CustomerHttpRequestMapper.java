package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.mapper;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.entities.valueobjects.*;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerPatchRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerHttpRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "identification", source = "identification", qualifiedByName = "toIdentification")
    @Mapping(target = "fullName", source = "name", qualifiedByName = "toFullName")
    @Mapping(target = "email", source = "email", qualifiedByName = "toEmail")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "toPhone")
    @Mapping(target = "address", source = "address", qualifiedByName = "toAddress")
    @Mapping(target = "status", source = "status", qualifiedByName = "toStatus")
    Customer toCustomer(CustomerCreateRequestDto customerCreateRequestDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "identification", ignore = true)
    @Mapping(target = "fullName", source = "name", qualifiedByName = "toFullName")
    @Mapping(target = "email", source = "email", qualifiedByName = "toEmail")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "toPhone")
    @Mapping(target = "address", source = "address", qualifiedByName = "toAddress")
    @Mapping(target = "status", source = "status", qualifiedByName = "toStatus")
    Customer toCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "identification", ignore = true)
    @Mapping(target = "fullName", source = "name", qualifiedByName = "toFullName")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", source = "phone", qualifiedByName = "toPhone")
    @Mapping(target = "address", source = "address", qualifiedByName = "toAddress")
    @Mapping(target = "status", source = "status", qualifiedByName = "toStatus")
    Customer toCustomer(CustomerPatchRequestDto customerPatchRequestDto);

    @Mapping(target = "customerId", source = "id.value")
    @Mapping(target = "name", source = "fullName.value")
    @Mapping(target = "identification", source = "identification.value")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "phone", source = "phone.value")
    @Mapping(target = "address", source = "address.value")
    @Mapping(target = "status", source = "status.value")
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "password", ignore = true)
    CustomerDto toCustomerDto(Customer customer);

    @Named("toIdentification")
    default Identification toIdentification(String value) {
        return value == null ? null : new Identification(value);
    }

    @Named("toFullName")
    default FullName toFullName(String value) {
        return value == null ? null : new FullName(value);
    }

    @Named("toEmail")
    default Email toEmail(String value) {
        return value == null ? null : new Email(value);
    }

    @Named("toPhone")
    default Phone toPhone(String value) {
        return value == null ? null : new Phone(value);
    }

    @Named("toAddress")
    default Address toAddress(String value) {
        return value == null ? null : new Address(value);
    }

    @Named("toStatus")
    default Status toStatus(Boolean value) {
        return value == null ? null : new Status(value);
    }

}