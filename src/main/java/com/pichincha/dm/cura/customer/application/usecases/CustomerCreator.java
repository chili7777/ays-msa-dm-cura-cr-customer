package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.entities.identifiers.CustomerId;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.CreateCustomerInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.CreateCustomerOutputPort;
import java.util.UUID;
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
    public Mono<Void> createCustomer(Customer customer) {
        Customer customerToSave = customer.id() == null
                ? new Customer(new CustomerId(UUID.randomUUID().toString()),
                               customer.identification(),
                               customer.fullName(),
                               customer.email(),
                               customer.phone(),
                               customer.address(),
                               customer.status())
                : customer;
        return repository.save(customerToSave);
    }

}