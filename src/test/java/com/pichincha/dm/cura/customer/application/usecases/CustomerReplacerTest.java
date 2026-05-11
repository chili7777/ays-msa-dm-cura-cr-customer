package com.pichincha.dm.cura.customer.application.usecases;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.ReplaceCustomerOutputPort;
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
final class CustomerReplacerTest {

    @Mock
    private ReplaceCustomerOutputPort customerPersistence;

    @InjectMocks
    private CustomerReplacer customerReplacer;

    @Test
    void given_existingCustomerIdAndNewData_when_updateCustomer_then_replaceCustomer() {
        String customerId = UuidMother.random().toString();
        Customer newCustomerData = CustomerMother.random();

        when(customerPersistence.update(customerId, newCustomerData)).thenReturn(Mono.empty());

        customerReplacer.replaceCustomer(customerId, newCustomerData).block();

        verify(customerPersistence, atLeastOnce()).update(customerId, newCustomerData);
    }
}