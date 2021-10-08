package com.sofka.teststepverifier;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
@Service
public final class ServicePerson {

    public Mono<String> searchOne() {
        return Mono.just("Pedro");
    }
    public Flux<String> searchAll() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen");
    }
    public Flux<String> searchSlowly() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen").delaySequence(Duration.ofSeconds(20));
    }


    public Flux<String> searchAllByFilter() {
        Flux<String> source = Flux.just("John", "Monica", "Mark", "Cloe", "Frank", "Casper", "Olivia", "Emily", "Cate")
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase);

        return source;
    }
    public Flux<Long> buscarNumerosTiempo() {
        Flux<Long> source = Flux.just(0L,1L);

        return source;
    }

}
