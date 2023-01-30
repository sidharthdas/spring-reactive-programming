package io.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .doOnError(er -> System.out.println("Error!!! " + er.getLocalizedMessage()))
                .subscribe(System.out::println);

        ReactiveSources.intNumbersFluxWithException()
                .subscribe(System.out::println,
                        err -> System.out.println("Error occured"));

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err2, item) -> System.out.println("Error : " + err2.getMessage()))
                .subscribe(x -> System.out.println(x));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);
        System.out.println("Press a key to end");
        System.in.read();
    }

}
