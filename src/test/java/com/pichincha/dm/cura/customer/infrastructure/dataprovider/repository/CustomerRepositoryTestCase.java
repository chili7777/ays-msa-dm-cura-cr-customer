package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import com.pichincha.dm.cura.customer.shared.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Specialized test case for customer repository integration tests.
 * Provides autowired access to the customer repository, allowing for
 * automated testing of persistence operations.
 */
public abstract class CustomerRepositoryTestCase extends InfrastructureTestCase {

    @Autowired
    protected InMemoryCustomerRepository repository;

}