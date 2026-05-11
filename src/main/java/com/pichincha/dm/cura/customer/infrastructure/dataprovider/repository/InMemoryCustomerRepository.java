package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.CreateCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.DeleteCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.GetCustomerByIdOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ListCustomersOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.PatchCustomerOutputPort;
import com.pichincha.dm.cura.customer.application.usecases.ports.output.ReplaceCustomerOutputPort;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.entities.CustomerEntity;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.mapper.CustomerRepositoryMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Profile({"test", "local", "default", "development", "staging", "production"})
@RequiredArgsConstructor
public final class InMemoryCustomerRepository implements CreateCustomerOutputPort, ListCustomersOutputPort, GetCustomerByIdOutputPort, ReplaceCustomerOutputPort, PatchCustomerOutputPort, DeleteCustomerOutputPort {

    private final Map<String, CustomerEntity> customers = new HashMap<>();
    private final CustomerRepositoryMapper mapper;

    @Override
    public Mono<Void> save(Customer customer) {
        return Mono.fromRunnable(() -> {
            CustomerEntity entity = mapper.toCustomerEntity(customer);
            customers.put(entity.id(), entity);
        });
    }

    @Override
    public Flux<Customer> findAll(Boolean status) {
        return Flux.fromIterable(customers.values())
                .filter(entity -> status == null || entity.status().equals(status))
                .map(mapper::toCustomer);
    }

    @Override
    public Mono<Customer> findById(String customerId) {
        return Mono.justOrEmpty(customers.get(customerId))
                .map(mapper::toCustomer);
    }

    @Override
    public Mono<Void> update(String customerId, Customer customer) {
        return Mono.fromRunnable(() -> {
            CustomerEntity existing = customers.get(customerId);
            if (existing != null) {
                CustomerEntity updated = new CustomerEntity(
                        existing.id(),
                        customer.identification() != null ? customer.identification().getValue() : existing.identification(),
                        customer.fullName() != null ? customer.fullName().getValue() : existing.fullName(),
                        customer.email() != null ? customer.email().getValue() : existing.email(),
                        customer.phone() != null ? customer.phone().getValue() : existing.phone(),
                        customer.address() != null ? customer.address().getValue() : existing.address(),
                        customer.status() != null ? customer.status().getValue() : existing.status()
                );
                customers.put(customerId, updated);
            }
        });
    }

    @Override
    public Mono<Void> patch(String customerId, Customer customer) {
        return Mono.fromRunnable(() -> {
            CustomerEntity existing = customers.get(customerId);
            if (existing != null) {
                CustomerEntity updated = new CustomerEntity(
                        existing.id(),
                        existing.identification(),
                        customer.fullName() != null ? customer.fullName().getValue() : existing.fullName(),
                        customer.email() != null ? customer.email().getValue() : existing.email(),
                        customer.phone() != null ? customer.phone().getValue() : existing.phone(),
                        customer.address() != null ? customer.address().getValue() : existing.address(),
                        customer.status() != null ? customer.status().getValue() : existing.status()
                );
                customers.put(customerId, updated);
            }
        });
    }

    @Override
    public Mono<Void> deactivate(String customerId) {
        return Mono.fromRunnable(() -> {
            CustomerEntity existing = customers.get(customerId);
            if (existing != null) {
                CustomerEntity deactivated = new CustomerEntity(
                        existing.id(),
                        existing.identification(),
                        existing.fullName(),
                        existing.email(),
                        existing.phone(),
                        existing.address(),
                        false
                );
                customers.put(customerId, deactivated);
            }
        });
    }
}