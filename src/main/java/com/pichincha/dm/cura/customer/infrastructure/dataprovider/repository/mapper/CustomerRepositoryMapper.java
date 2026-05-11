package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.mapper;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.entities.valueobjects.*;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper interface for converting between customer domain models and persistence entities.
 * Leverages MapStruct to generate high-performance, type-safe mapping code.
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerRepositoryMapper {

    @Mapping(target = "identification", source = "identification.value")
    @Mapping(target = "fullName", source = "fullName.value")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "phone", source = "phone.value")
    @Mapping(target = "address", source = "address.value")
    @Mapping(target = "status", source = "status.value")
    CustomerEntity toEntity(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "identification", source = "identification", qualifiedByName = "toIdentification")
    @Mapping(target = "fullName", source = "fullName", qualifiedByName = "toFullName")
    @Mapping(target = "email", source = "email", qualifiedByName = "toEmail")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "toPhone")
    @Mapping(target = "address", source = "address", qualifiedByName = "toAddress")
    @Mapping(target = "status", source = "status", qualifiedByName = "toStatus")
    Customer toDomain(CustomerEntity entity);

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