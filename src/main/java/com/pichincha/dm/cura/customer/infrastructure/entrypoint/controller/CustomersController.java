package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller;

import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.CustomerCreateRequestDto;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Handles incoming HTTP requests for customer-related operations, delegating to the domain ports
 * and mapping between infrastructure-specific transport models and domain entities.
 */
@RestController
public class CustomersController implements CustomersApi {

    private static final ResponseEntity<Void> CREATED_RESPONSE = ResponseEntity.status(HttpStatus.CREATED).build();

    @Override
    public Mono<ResponseEntity<Void>> createCustomer(UUID xGuid,
                                                     String xApp,
                                                     Mono<CustomerCreateRequestDto> customerCreateRequestDto,
                                                     ServerWebExchange exchange) {
        return customerCreateRequestDto.map(request -> CREATED_RESPONSE);
    }

}