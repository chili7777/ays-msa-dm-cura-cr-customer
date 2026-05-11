package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.domain.usecases.ports.output.CreateCustomerOutputPort;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * In-memory implementation of the customer persistence port.
 * Stores customer records in a concurrent-safe-like map (HashMap used in a non-concurrent way for now)
 * for fast prototyping and testing without requiring a real database.
 */
@Repository
@Profile("test")
@RequiredArgsConstructor
public final class InMemoryCustomerRepository implements CreateCustomerOutputPort {

    private final Map<String, Customer> customers = new HashMap<>();

    @Override
    public Mono<Void> save(Customer customer) {
        customers.put(customer.identification(), customer);
        return Mono.empty();
    }

    /**
     * Finds a customer by their identification number.
     * @param identification the unique identification string.
     * @return a Mono containing the customer if found, or empty otherwise.
     */
    public Mono<Customer> findByIdentification(String identification) {
        return Mono.justOrEmpty(customers.get(identification));
    }

}