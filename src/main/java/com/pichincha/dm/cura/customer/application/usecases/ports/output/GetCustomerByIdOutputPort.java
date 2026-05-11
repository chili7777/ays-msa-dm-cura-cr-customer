package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

public interface GetCustomerByIdOutputPort {
    Mono<Customer> findById(String customerId);
}
