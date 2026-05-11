package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository.mapper.CustomerRepositoryMapperImpl;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.IdentificationMother;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the in-memory customer repository.
 * Verifies that customers can be correctly saved and retrieved from the internal map,
 * and that non-existent records are handled gracefully.
 */
final class InMemoryCustomerRepositoryTest {

    @Test
    void given_validCustomer_when_save_then_customerIsPersisted() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository(new CustomerRepositoryMapperImpl());
        Customer customer = CustomerMother.random();

        repository.save(customer).block();

        Customer found = repository.findByIdentification(customer.identification().getValue()).block();
        assertNotNull(found);
    }

    @Test
    void given_savedCustomer_when_findByIdentification_then_returnCustomer() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository(new CustomerRepositoryMapperImpl());
        Customer customer = CustomerMother.random();
        repository.save(customer).block();

        Customer found = repository.findByIdentification(customer.identification().getValue()).block();

        assertNotNull(found);
        assertTrue(found.identification().equals(customer.identification()));
    }

    @Test
    void given_nonExistingIdentification_when_findByIdentification_then_returnEmpty() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository(new CustomerRepositoryMapperImpl());

        boolean isPresent = repository.findByIdentification(IdentificationMother.random().getValue()).blockOptional().isPresent();

        assertFalse(isPresent);
    }

}