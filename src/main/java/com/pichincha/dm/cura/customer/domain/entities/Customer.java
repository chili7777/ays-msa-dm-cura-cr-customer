package com.pichincha.dm.cura.customer.domain.entities;

/**
 * Domain record representing a customer within the core business logic.
 * Encapsulates essential person attributes and identity information, serving as the
 * primary model for customer lifecycle operations and validation.
 */
public record Customer(String identification,
                       String fullName,
                       String email,
                       String phone,
                       String address,
                       Boolean status) {
}