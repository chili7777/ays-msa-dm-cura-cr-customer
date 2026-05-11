package com.pichincha.dm.cura.customer.domain.entities;

import com.pichincha.dm.cura.customer.domain.entities.identifiers.CustomerId;

/**
 * Domain record representing a customer within the core business logic.
 * Encapsulates essential person attributes and identity information, serving as the
 * primary model for customer lifecycle operations and validation.
 */
public record Customer(CustomerId id,
                       String identification,
                       String fullName,
                       String email,
                       String phone,
                       String address,
                       Boolean status) {
}