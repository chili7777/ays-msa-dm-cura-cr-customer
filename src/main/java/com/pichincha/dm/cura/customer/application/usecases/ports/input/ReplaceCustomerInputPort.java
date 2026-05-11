package com.pichincha.dm.cura.customer.application.usecases.ports.input;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

public interface ReplaceCustomerInputPort {
    Mono<Void> replaceCustomer(String customerId, Customer customer);
}