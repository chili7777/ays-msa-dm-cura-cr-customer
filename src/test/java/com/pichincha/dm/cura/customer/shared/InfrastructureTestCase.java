package com.pichincha.dm.cura.customer.shared;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Base class for all infrastructure-level integration tests.
 * Sets up the Spring Boot test context with the 'test' profile to enable
 * integration with real or in-memory infrastructure components.
 */
@SpringBootTest
@ActiveProfiles("test")
public abstract class InfrastructureTestCase {
}