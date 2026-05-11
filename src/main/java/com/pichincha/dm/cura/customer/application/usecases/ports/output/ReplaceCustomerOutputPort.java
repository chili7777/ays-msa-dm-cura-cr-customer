package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

public interface ReplaceCustomerOutputPort {
    Mono<Void> update(String customerId, Customer customer);
}
