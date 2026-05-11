package com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller;

import com.pichincha.dm.cura.customer.application.usecases.ports.input.*;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.entities.*;
import com.pichincha.dm.cura.customer.infrastructure.entrypoint.controller.mapper.CustomerHttpRequestMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CustomersController implements CustomersApi {

    private final CreateCustomerInputPort createCustomerUseCase;
    private final ListCustomersInputPort listCustomersUseCase;
    private final GetCustomerByIdInputPort getCustomerByIdUseCase;
    private final ReplaceCustomerInputPort replaceCustomerUseCase;
    private final PatchCustomerInputPort patchCustomerUseCase;
    private final DeleteCustomerInputPort deleteCustomerUseCase;
    private final CustomerHttpRequestMapper mapper;

    @Override
    public Mono<ResponseEntity<Void>> createCustomer(UUID xGuid,
                                                     String xApp,
                                                     Mono<CustomerCreateRequestDto> customerCreateRequestDto,
                                                     ServerWebExchange exchange) {
        return customerCreateRequestDto
                .map(mapper::toCustomer)
                .flatMap(createCustomerUseCase::createCustomer)
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @Override
    public Mono<ResponseEntity<Flux<CustomerDto>>> listCustomers(UUID xGuid,
                                                                 String xApp,
                                                                 String identification,
                                                                 Boolean status,
                                                                 ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(listCustomersUseCase.listCustomers(status).map(mapper::toCustomerDto)));
    }

    @Override
    public Mono<ResponseEntity<CustomerDto>> getCustomerById(UUID xGuid,
                                                             String xApp,
                                                             UUID customerId,
                                                             ServerWebExchange exchange) {
        return getCustomerByIdUseCase.getCustomerById(customerId.toString())
                .map(mapper::toCustomerDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<CustomerDto>> replaceCustomer(UUID xGuid,
                                                             String xApp,
                                                             UUID customerId,
                                                             Mono<CustomerUpdateRequestDto> customerUpdateRequestDto,
                                                             ServerWebExchange exchange) {
        return customerUpdateRequestDto
                .map(mapper::toCustomer)
                .flatMap(customer -> replaceCustomerUseCase.replaceCustomer(customerId.toString(), customer))
                .then(getCustomerByIdUseCase.getCustomerById(customerId.toString()))
                .map(mapper::toCustomerDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<CustomerDto>> patchCustomer(UUID xGuid,
                                                           String xApp,
                                                           UUID customerId,
                                                           Mono<CustomerPatchRequestDto> customerPatchRequestDto,
                                                           ServerWebExchange exchange) {
        return customerPatchRequestDto
                .map(mapper::toCustomer)
                .flatMap(customer -> patchCustomerUseCase.patchCustomer(customerId.toString(), customer))
                .then(getCustomerByIdUseCase.getCustomerById(customerId.toString()))
                .map(mapper::toCustomerDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomer(UUID xGuid,
                                                     String xApp,
                                                     UUID customerId,
                                                     ServerWebExchange exchange) {
        return deleteCustomerUseCase.deleteCustomer(customerId.toString())
                .thenReturn(ResponseEntity.noContent().<Void>build());
    }
}