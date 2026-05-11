package com.pichincha.dm.cura.customer.application.usecases.ports.input;

import reactor.core.publisher.Mono;

public interface DeleteCustomerInputPort {
    Mono<Void> deleteCustomer(String customerId);
}