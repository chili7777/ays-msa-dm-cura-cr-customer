package com.pichincha.dm.cura.customer.application.usecases.ports.input;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

public interface GetCustomerByIdInputPort {
    Mono<Customer> getCustomerById(String customerId);
}