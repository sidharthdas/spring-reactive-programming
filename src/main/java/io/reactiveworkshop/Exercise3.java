package io.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> l = ReactiveSources.intNumbersFlux()
                .log("Sidharth")
                .toStream()
                .toList();
        System.out.println(l);
        System.out.println(l.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
