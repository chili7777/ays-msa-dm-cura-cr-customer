package com.pichincha.dm.cura.customer.health;

import java.util.Collections;
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

    @GetMapping("/health-check")
    public Mono<Map<String, String>> index() {
        return Mono.just(Collections.singletonMap("status", "ok"));
    }

}