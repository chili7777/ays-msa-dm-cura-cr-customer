package com.pichincha.dm.cura.customer.application.usecases.ports.input;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

/**
 * Input port interface for the customer creation use case.
 * Defines the entry point for the application to initiate the customer creation process,
 * ensuring that the domain logic is decoupled from the specific entry points (controllers).
 */
public interface CreateCustomerInputPort {
    Mono<Void> createCustomer(Customer customer);
}