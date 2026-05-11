package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.mapper;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.entities.CustomerEntity;
import org.mapstruct.Mapper;
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

    CustomerEntity toEntity(Customer customer);

    Customer toDomain(CustomerEntity entity);

}