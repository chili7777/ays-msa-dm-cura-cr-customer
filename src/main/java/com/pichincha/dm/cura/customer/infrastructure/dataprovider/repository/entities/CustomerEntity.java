package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.entities;

/**
 * Persistence entity for customer data, used by the repository layer.
 * Decouples the domain model from the underlying data storage structure.
 */
public record CustomerEntity(String id,
                             String identification,
                             String fullName,
                             String email,
                             String phone,
                             String address,
                             Boolean status) {
}