package com.pichincha.dm.cura.customer.application.usecases;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.DeleteCustomerOutputPort;
import com.pichincha.dm.cura.customer.shared.objectmothers.UuidMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
final class CustomerDeactivatorTest {

    @Mock
    private DeleteCustomerOutputPort customerPersistence;

    @InjectMocks
    private CustomerDeactivator customerDeactivator;

    @Test
    void given_existingCustomerId_when_deleteCustomer_then_deactivateCustomer() {
        String customerId = UuidMother.random().toString();

        when(customerPersistence.deactivate(customerId)).thenReturn(Mono.empty());

        customerDeactivator.deleteCustomer(customerId).block();

        verify(customerPersistence, atLeastOnce()).deactivate(customerId);
    }
}