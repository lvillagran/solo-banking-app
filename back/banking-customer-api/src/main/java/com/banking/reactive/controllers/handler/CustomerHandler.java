package com.banking.reactive.controllers.handler;

import com.banking.reactive.model.Customer;
import com.banking.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

    @Autowired
    private CustomerService service;

    public CustomerHandler(CustomerService service) {
        this.service = service;
    }


    public Mono<ServerResponse> getAllCustomers(ServerRequest request) {
        return ServerResponse.ok().body(service.getAllCustomers(), Customer.class);
    }

    public Mono<ServerResponse> getCustomerById(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.getCustomerById(id)
                .flatMap(customer -> ServerResponse.ok().bodyValue(customer))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createCustomer(ServerRequest request) {
        return request.bodyToMono(Customer.class)
                .flatMap(service::saveCustomer)
                .flatMap(saved -> ServerResponse.ok().bodyValue(saved));
    }

    public Mono<ServerResponse> deleteCustomer(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.deleteCustomerById(id)
                .then(ServerResponse.noContent().build());
    }

    public Mono<ServerResponse> getCustomersByName(ServerRequest request) {
        String name = request.queryParam("name").orElse("");
        return ServerResponse.ok().body(service.getCustomersByName(name), Customer.class);
    }

    public Mono<ServerResponse> getCustomersByEmail(ServerRequest request) {
        String email = request.queryParam("email").orElse("");
        return ServerResponse.ok().body(service.getCustomersByEmail(email), Customer.class);
    }
}
