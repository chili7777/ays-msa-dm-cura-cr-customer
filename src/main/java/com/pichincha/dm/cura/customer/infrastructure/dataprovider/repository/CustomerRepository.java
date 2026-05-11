package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.CreateCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.DeleteCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.GetCustomerByIdOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ListCustomersOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.PatchCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ReplaceCustomerOutputPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Profile("!test & !local & !default & !development & !staging & !production")
public class CustomerRepository implements CreateCustomerOutputPort, ListCustomersOutputPort, GetCustomerByIdOutputPort, ReplaceCustomerOutputPort, PatchCustomerOutputPort, DeleteCustomerOutputPort {

    @Override
    public Mono<Void> save(Customer customer) {
        return Mono.empty();
    }

    @Override
    public Flux<Customer> findAll(Boolean status) {
        return Flux.empty();
    }

    @Override
    public Mono<Customer> findById(String customerId) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> update(String customerId, Customer customer) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> patch(String customerId, Customer customer) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> deactivate(String customerId) {
        return Mono.empty();
    }
}
