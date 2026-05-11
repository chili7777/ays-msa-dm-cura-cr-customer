package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller;

import com.pichincha.dm.cura.customer.application.usecases.ports.output.CreateCustomerOutputPort;
import com.pichincha.dm.cura.customer.domain.entities.Customer;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerPatchRequestDto;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerUpdateRequestDto;
import com.pichincha.dm.cura.customer.shared.RequestTestCase;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerCreateRequestDtoMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerPatchRequestDtoMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.CustomerUpdateRequestDtoMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.HttpHeadersMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.JsonMother;
import com.pichincha.dm.cura.customer.shared.objectmothers.UuidMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CustomersControllerTest extends RequestTestCase {

    @Autowired
    private CreateCustomerOutputPort repository;

    private String customerId;

    @BeforeEach
    void setUp() {
        Customer customer = CustomerMother.random();
        repository.save(customer).block();
        this.customerId = customer.id().getValue();
    }

    @Test
    void given_validCustomerCreateRequest_when_createCustomer_then_returnCreatedStatus() throws Exception {
        CustomerCreateRequestDto requestDto = CustomerCreateRequestDtoMother.random();
        String requestBody = JsonMother.fromObject(requestDto);

        assertRequestWithBody("POST", "/customers", requestBody, 201, HttpHeadersMother.random());
    }

    @Test
    void when_listCustomers_then_returnOkStatus() throws Exception {
        assertRequest("GET", "/customers", 200, HttpHeadersMother.random());
    }

    @Test
    void given_customerId_when_getCustomerById_then_returnOkStatus() throws Exception {
        assertRequest("GET", "/customers/" + customerId, 200, HttpHeadersMother.random());
    }

    @Test
    void given_validCustomerUpdateRequest_when_replaceCustomer_then_returnNoContentStatus() throws Exception {
        CustomerUpdateRequestDto requestDto = CustomerUpdateRequestDtoMother.random();
        String requestBody = JsonMother.fromObject(requestDto);

        assertRequestWithBody("PUT", "/customers/" + customerId, requestBody, 200, HttpHeadersMother.random());
    }

    @Test
    void given_validCustomerPatchRequest_when_patchCustomer_then_returnNoContentStatus() throws Exception {
        CustomerPatchRequestDto requestDto = CustomerPatchRequestDtoMother.random();
        String requestBody = JsonMother.fromObject(requestDto);

        assertRequestWithBody("PATCH", "/customers/" + customerId, requestBody, 200, HttpHeadersMother.random());
    }

    @Test
    void given_customerId_when_deleteCustomer_then_returnNoContentStatus() throws Exception {
        assertRequest("DELETE", "/customers/" + customerId, 204, HttpHeadersMother.random());
    }
}