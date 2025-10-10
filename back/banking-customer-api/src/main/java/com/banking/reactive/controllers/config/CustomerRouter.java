package com.banking.reactive.controllers.config;

import com.banking.reactive.controllers.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CustomerRouter {

    @Bean
    public RouterFunction<ServerResponse> customerRoutes(CustomerHandler handler) {
        return route(GET("/api/v1/customers"), handler::getAllCustomers)
                .andRoute(GET("/api/v1/customers/{id}"), handler::getCustomerById)
                .andRoute(POST("/api/v1/customers"), handler::createCustomer)
                .andRoute(DELETE("/api/v1/customers/{id}"), handler::deleteCustomer)
                .andRoute(GET("/api/v1/customers/search/by-name"), handler::getCustomersByName)
                .andRoute(GET("/api/v1/customers/search/by-email"), handler::getCustomersByEmail);
    }
}