package com.banking.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banking.reactive.model.Customer;
import com.banking.reactive.repository.CustomerRepository;

@Service
public class CustomerService {

        private final CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        // Obtener todos los clientes
        public Flux<Customer> getAllCustomers() {
            return repository.findAll();
        }

        // Obtener un cliente por su ID
        public Mono<Customer> getCustomerById(String id) {
            return repository.findById(id);
        }

        // Crear o actualizar un cliente
        public Mono<Customer> saveCustomer(Customer customer) {
            return repository.save(customer);
        }

        // Eliminar un cliente por ID
        public Mono<Void> deleteCustomerById(String id) {
            return repository.deleteById(id);
        }

        // Buscar por nombre (devuelve varios)
        public Flux<Customer> getCustomersByName(String name) {
            return repository.findByName(name);
        }

        // Buscar por email (puede haber varios)
        public Flux<Customer> getCustomersByEmail(String email) {
            return repository.findByEmail(email);
        }
    }
