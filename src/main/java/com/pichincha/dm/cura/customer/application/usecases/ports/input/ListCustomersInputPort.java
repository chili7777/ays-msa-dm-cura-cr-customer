package com.pichincha.dm.cura.customer.application.usecases.ports.input;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Flux;

public interface ListCustomersInputPort {
    Flux<Customer> listCustomers(Boolean status);
}