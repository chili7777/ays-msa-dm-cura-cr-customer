package com.pichincha.dm.cura.customer.application.usecases;

import com.pichincha.dm.cura.customer.domain.annotations.UseCaseService;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.input.ListCustomersInputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ListCustomersOutputPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@UseCaseService
@RequiredArgsConstructor
public class CustomerLister implements ListCustomersInputPort {

    private final ListCustomersOutputPort repository;

    @Override
    public Flux<Customer> listCustomers(Boolean status) {
        return repository.findAll(status);
    }
}