package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.PatchCustomerInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.PatchCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@UseCaseService
@RequiredArgsConstructor
public class CustomerPatcher implements PatchCustomerInputPort {

    private final PatchCustomerOutputPort repository;

    @Override
    public Mono<Void> patchCustomer(String customerId, Customer customer) {
        return repository.patch(customerId, customer);
    }
}