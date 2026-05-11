package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.mapper;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.entities.identifiers.CustomerId;
import com.pichincha.dm.cura.customer.domain.entities.valueobjects.*;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerRepositoryMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "fromCustomerIdToString")
    @Mapping(target = "identification", source = "identification", qualifiedByName = "fromValueObjectToString")
    @Mapping(target = "fullName", source = "fullName", qualifiedByName = "fromValueObjectToString")
    @Mapping(target = "email", source = "email", qualifiedByName = "fromValueObjectToString")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "fromValueObjectToString")
    @Mapping(target = "address", source = "address", qualifiedByName = "fromValueObjectToString")
    @Mapping(target = "status", source = "status", qualifiedByName = "fromValueObjectToBoolean")
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "id", source = "id", qualifiedByName = "toCustomerId")
    @Mapping(target = "identification", source = "identification", qualifiedByName = "toIdentification")
    @Mapping(target = "fullName", source = "fullName", qualifiedByName = "toFullName")
    @Mapping(target = "email", source = "email", qualifiedByName = "toEmail")
    @Mapping(target = "phone", source = "phone", qualifiedByName = "toPhone")
    @Mapping(target = "address", source = "address", qualifiedByName = "toAddress")
    @Mapping(target = "status", source = "status", qualifiedByName = "toStatus")
    Customer toCustomer(CustomerEntity entity);

    @Named("fromCustomerIdToString")
    default String fromCustomerIdToString(CustomerId customerId) {
        return customerId == null ? null : customerId.getValue();
    }

    @Named("fromValueObjectToString")
    default String fromValueObjectToString(ValueObject<String> valueObject) {
        return valueObject == null ? null : valueObject.getValue();
    }

    @Named("fromValueObjectToBoolean")
    default Boolean fromValueObjectToBoolean(ValueObject<Boolean> valueObject) {
        return valueObject == null ? null : valueObject.getValue();
    }

    @Named("toCustomerId")
    default CustomerId toCustomerId(String id) {
        return id == null ? null : new CustomerId(id);
    }

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