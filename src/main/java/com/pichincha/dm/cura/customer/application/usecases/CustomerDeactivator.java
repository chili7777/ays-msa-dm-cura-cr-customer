package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.DeleteCustomerInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.DeleteCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@UseCaseService
@RequiredArgsConstructor
public class CustomerDeactivator implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort repository;

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return repository.deactivate(customerId);
    }
}