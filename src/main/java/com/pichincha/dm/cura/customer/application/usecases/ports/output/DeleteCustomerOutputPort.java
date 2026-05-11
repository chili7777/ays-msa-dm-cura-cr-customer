package com.pichincha.dm.cura.customer.application.usecases.ports.output;

import reactor.core.publisher.Mono;

public interface DeleteCustomerOutputPort {
    Mono<Void> deactivate(String customerId);
}
