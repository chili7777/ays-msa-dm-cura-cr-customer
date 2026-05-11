package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.GetCustomerByIdInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.GetCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@UseCaseService
@RequiredArgsConstructor
public class CustomerFinder implements GetCustomerByIdInputPort {

    private final GetCustomerByIdOutputPort repository;

    @Override
    public Mono<Customer> getCustomerById(String customerId) {
        return repository.findById(customerId);
    }
}