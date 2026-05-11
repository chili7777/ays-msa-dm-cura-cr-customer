package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerIdMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.StatusMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.FullNameMother;
import java.util.List;
import org.junit.jupiter.api.Test;

final class InMemoryCustomerRepositoryTest extends CustomerInfrastructureTestCase {

    @Test
    void given_validCustomer_when_save_then_customerIsPersisted() {
        Customer customer = CustomerMother.random();

        repository.save(customer).block();
        Customer found = repository.findById(customer.id().getValue()).block();

        assertNotNull(found);
        assertEquals(customer.id(), found.id());
    }

    @Test
    void given_savedCustomer_when_findById_then_returnCustomer() {
        Customer customer = CustomerMother.random();

        repository.save(customer).block();
        Customer found = repository.findById(customer.id().getValue()).block();

        assertNotNull(found);
        assertTrue(found.id().equals(customer.id()));
    }

    @Test
    void given_nonExistingCustomerId_when_findById_then_returnEmpty() {
        String nonExistingCustomerId = CustomerIdMother.random().getValue();

        boolean isPresent = repository.findById(nonExistingCustomerId).blockOptional().isPresent();

        assertFalse(isPresent);
    }

    @Test
    void given_multipleCustomers_when_findAll_then_returnAll() {
        Customer customer1 = CustomerMother.random();
        Customer customer2 = CustomerMother.random();

        repository.save(customer1).block();
        repository.save(customer2).block();

        List<Customer> all = repository.findAll(null).collectList().block();

        assertNotNull(all);
        assertTrue(all.size() >= 2);
    }

    @Test
    void given_savedCustomer_when_update_then_customerIsUpdated() {
        Customer customer = CustomerMother.random();
        repository.save(customer).block();

        Customer updatedCustomer = new Customer(
                customer.id(),
                customer.identification(),
                FullNameMother.random(),
                customer.email(),
                customer.phone(),
                customer.address(),
                customer.status()
        );

        repository.update(customer.id().getValue(), updatedCustomer).block();
        Customer found = repository.findById(customer.id().getValue()).block();

        assertNotNull(found);
        assertEquals(updatedCustomer.fullName(), found.fullName());
    }

    @Test
    void given_savedCustomer_when_patch_then_customerIsPartiallyUpdated() {
        Customer customer = CustomerMother.random();
        repository.save(customer).block();

        Customer partialCustomer = new Customer(
                null, null,
                FullNameMother.random(),
                null, null, null,
                StatusMother.random()
        );

        repository.patch(customer.id().getValue(), partialCustomer).block();
        Customer found = repository.findById(customer.id().getValue()).block();

        assertNotNull(found);
        assertEquals(partialCustomer.fullName(), found.fullName());
        assertEquals(partialCustomer.status(), found.status());
        assertEquals(customer.email(), found.email());
    }

    @Test
    void given_savedCustomer_when_deactivate_then_customerIsDeactivated() {
        Customer customer = CustomerMother.randomWithId(CustomerIdMother.random());
        // Ensure it is active first
        customer = new Customer(customer.id(), customer.identification(), customer.fullName(), customer.email(), customer.phone(), customer.address(), new com.pichincha.dm.cura.customer.domain.entities.valueobjects.Status(true));

        repository.save(customer).block();

        repository.deactivate(customer.id().getValue()).block();
        Customer found = repository.findById(customer.id().getValue()).block();

        assertNotNull(found);
        assertFalse(found.status().getValue());
    }
}