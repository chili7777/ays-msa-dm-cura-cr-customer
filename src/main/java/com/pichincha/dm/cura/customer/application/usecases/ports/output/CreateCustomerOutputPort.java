package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

/**
 * Output port interface for customer persistence operations.
 * Defines the contract that must be implemented by infrastructure adapters (repositories)
 * to allow the domain layer to save and retrieve customer data.
 */
public interface CreateCustomerOutputPort {

    Mono<Void> save(Customer customer);

}
