package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Flux;

public interface ListCustomersOutputPort {
    Flux<Customer> findAll(Boolean status);
}
