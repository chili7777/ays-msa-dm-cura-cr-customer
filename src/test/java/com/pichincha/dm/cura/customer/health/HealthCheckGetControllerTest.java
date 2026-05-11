package com.pichincha.dm.cura.customer.health;

import com.pichincha.dm.cura.customer.shared.RequestTestCase;
import org.junit.jupiter.api.Test;

class HealthCheckGetControllerTest extends RequestTestCase {

    @Test
    void shouldReturnHealthCheckStatusWhenInvoked() throws Exception {
        assertResponse("/health-check", 200, "{ \"status\": \"ok\" }");
    }

}