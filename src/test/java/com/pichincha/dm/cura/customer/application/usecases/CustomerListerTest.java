package com.pichincha.dm.cura.customer.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.ListCustomersOutputPort;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerMother;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

@ExtendWith(MockitoExtension.class)
final class CustomerListerTest {

    @Mock
    private ListCustomersOutputPort customerPersistence;

    @InjectMocks
    private CustomerLister customerLister;

    @Test
    void when_getAllCustomers_then_returnListOfCustomers() {
        List<Customer> customers = List.of(CustomerMother.random(), CustomerMother.random());

        when(customerPersistence.findAll(null)).thenReturn(Flux.fromIterable(customers));

        List<Customer> found = customerLister.listCustomers(null).collectList().block();

        assertEquals(customers.size(), found.size());
        assertEquals(customers, found);
    }
}