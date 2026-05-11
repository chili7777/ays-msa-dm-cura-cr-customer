package com.pichincha.dm.cura.customer.infrastructure.dataprovider.repository;

import com.pichincha.dm.cura.customer.shared.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CustomerInfrastructureTestCase extends InfrastructureTestCase {

    @Autowired
    protected InMemoryCustomerRepository repository;
}