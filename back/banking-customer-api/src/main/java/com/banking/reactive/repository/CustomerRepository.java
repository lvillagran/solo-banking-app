package com.banking.reactive.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import com.banking.reactive.model.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

        // Ejemplo de búsqueda personalizada
        Flux<Customer> findByName(String name);

        // Puedes agregar más métodos con nombres basados en propiedades, como:
        Flux<Customer> findByEmail(String email);
    }

