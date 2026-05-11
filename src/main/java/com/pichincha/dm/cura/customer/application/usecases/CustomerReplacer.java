package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.ReplaceCustomerInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ReplaceCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@UseCaseService
@RequiredArgsConstructor
public class CustomerReplacer implements ReplaceCustomerInputPort {

    private final ReplaceCustomerOutputPort repository;

    @Override
    public Mono<Void> replaceCustomer(String customerId, Customer customer) {
        return repository.update(customerId, customer);
    }
}