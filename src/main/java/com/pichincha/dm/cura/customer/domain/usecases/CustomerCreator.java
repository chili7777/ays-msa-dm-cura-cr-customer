package com.pichincha.dm.cura.customer.domain.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.usecases.ports.input.CreateCustomerInputPort;
import com.pichincha.dm.cura.customer.domain.usecases.ports.output.CreateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Domain use case implementation for creating new customers.
 * Coordinates the customer creation process, including domain validation and persistence
 * through the defined output ports.
 */
@UseCaseService
@RequiredArgsConstructor
public class CustomerCreator implements CreateCustomerInputPort {

    private final CreateCustomerOutputPort repository;

    @Override
    public Mono<Void> create(Customer customer) {
        return repository.save(customer);
    }

}