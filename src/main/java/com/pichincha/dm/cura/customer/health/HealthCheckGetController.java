package com.pichincha.dm.cura.customer.health;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Endpoint for health checking.
 * Provides a simple "ok" status response to verify that the application and its dependencies
 * are running correctly, used mainly for load balancer or container orchestrator probes.
 */
@RestController
public class HealthCheckGetController {

    private static final String STATUS_KEY = "status";
    private static final String STATUS_OK = "ok";
    private static final Map<String, String> HEALTH_RESPONSE = Map.of(STATUS_KEY, STATUS_OK);

    @GetMapping("/health-check")
    public Mono<Map<String, String>> healthCheck() {
        return Mono.just(HEALTH_RESPONSE);
    }

}