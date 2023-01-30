package io.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(x -> System.out.println(x));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(x -> System.out.println(x));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
