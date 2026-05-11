package com.pichincha.dm.cura.customer.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.GetCustomerByIdOutputPort;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.UuidMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
final class CustomerFinderTest {

    @Mock
    private GetCustomerByIdOutputPort customerPersistence;

    @InjectMocks
    private CustomerFinder customerFinder;

    @Test
    void given_existingCustomerId_when_getCustomerById_then_returnCustomer() {
        String customerId = UuidMother.random().toString();
        Customer customer = CustomerMother.random();

        when(customerPersistence.findById(customerId)).thenReturn(Mono.just(customer));

        Customer found = customerFinder.getCustomerById(customerId).block();

        assertEquals(customer, found);
    }
}