package com.pichincha.dm.cura.customer.application.usecases;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.PatchCustomerOutputPort;
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
final class CustomerPatcherTest {

    @Mock
    private PatchCustomerOutputPort customerPersistence;

    @InjectMocks
    private CustomerPatcher customerPatcher;

    @Test
    void given_existingCustomerIdAndPartialData_when_patchCustomer_then_persistPartialChanges() {
        String customerId = UuidMother.random().toString();
        Customer partialCustomer = CustomerMother.random();

        when(customerPersistence.patch(customerId, partialCustomer)).thenReturn(Mono.empty());

        customerPatcher.patchCustomer(customerId, partialCustomer).block();

        verify(customerPersistence, atLeastOnce()).patch(customerId, partialCustomer);
    }
}