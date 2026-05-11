package com.pichincha.dm.cura.customer.health;

import com.pichincha.dm.cura.customer.shared.RequestTestCase;
import org.junit.jupiter.api.Test;

/**
 * Validates the health-check endpoint contract, ensuring the service responds with the expected HTTP status and JSON payload to confirm operational readiness.
 */
class HealthCheckGetControllerTest extends RequestTestCase {

    @Test
    void shouldReturnHealthCheckStatusWhenInvoked() throws Exception {
        assertResponse("/health-check", 200, "{ \"status\": \"ok\" }");
    }

}