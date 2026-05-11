package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.mapper;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper interface for converting between HTTP request DTOs and customer domain models.
 * Ensures that the application layer receives clean domain objects while isolating
 * transport-specific details.
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerHttpRequestMapper {

    Customer toCustomer(CustomerCreateRequestDto customerCreateRequestDto);

}