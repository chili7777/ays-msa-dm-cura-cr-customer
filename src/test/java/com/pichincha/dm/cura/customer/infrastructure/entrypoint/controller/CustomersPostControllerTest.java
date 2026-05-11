package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller;

import com.pichincha.dm.cura.customer.shared.RequestTestCase;
import com.pichincha.dm.cura.customer.shared.objectmothers.HttpHeadersMother;
import org.junit.jupiter.api.Test;

/**
 * Validates the customer creation endpoint, ensuring that valid customer data
 * results in a successful resource creation and the appropriate HTTP status code.
 */
class CustomersPostControllerTest extends RequestTestCase {

    @Test
    void given_validCustomerData_when_createCustomer_then_return201() throws Exception {
        String requestBody = """
                {
                  "identification": "1712345678",
                  "name": "Juan Perez",
                  "email": "juan.perez@example.com",
                  "phone": "0987654321",
                  "address": "Av. Siempre Viva 123",
                  "gender": "MALE",
                  "age": 30,
                  "password": "password123",
                  "status": true
                }
                """;

        assertRequestWithBody("POST", "/customers", requestBody, 201, HttpHeadersMother.standard());
    }

}