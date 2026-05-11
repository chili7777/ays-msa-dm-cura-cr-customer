package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the in-memory customer repository.
 * Verifies that customers can be correctly saved and retrieved from the internal map,
 * and that non-existent records are handled gracefully.
 */
final class InMemoryCustomerRepositoryTest {

    private static final String IDENTIFICATION = "1712345678";
    private static final String FULL_NAME = "Juan Perez";
    private static final String EMAIL = "juan.perez@example.com";
    private static final String PHONE = "0987654321";
    private static final String ADDRESS = "Av. Siempre Viva 123";
    private static final Boolean STATUS = true;

    @Test
    void given_validCustomer_when_save_then_customerIsPersisted() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        Customer customer = new Customer(IDENTIFICATION, FULL_NAME, EMAIL, PHONE, ADDRESS, STATUS);

        repository.save(customer).block();

        Customer found = repository.findByIdentification(IDENTIFICATION).block();
        assertNotNull(found);
    }

    @Test
    void given_savedCustomer_when_findByIdentification_then_returnCustomer() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        Customer customer = new Customer(IDENTIFICATION, FULL_NAME, EMAIL, PHONE, ADDRESS, STATUS);
        repository.save(customer).block();

        Customer found = repository.findByIdentification(IDENTIFICATION).block();

        assertNotNull(found);
        assertTrue(found.identification().equals(IDENTIFICATION));
    }

    @Test
    void given_nonExistingIdentification_when_findByIdentification_then_returnEmpty() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();

        boolean isPresent = repository.findByIdentification("NON-EXISTING").blockOptional().isPresent();

        assertFalse(isPresent);
    }

}