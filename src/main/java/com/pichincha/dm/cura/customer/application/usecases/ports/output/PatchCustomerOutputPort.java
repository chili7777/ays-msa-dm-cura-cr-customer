package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import reactor.core.publisher.Mono;

public interface PatchCustomerOutputPort {
    Mono<Void> patch(String customerId, Customer customer);
}
