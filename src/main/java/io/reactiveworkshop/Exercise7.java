package io.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(x -> x > 5)
                .subscribe(x -> System.out.println(x));

        // Print 10 multiplied each value from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(x -> x > 5)
                .map(x -> x * 10)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(x -> x > 5)
                .take(3)
                .map(x -> x * 10)
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1)
                .subscribe(x -> System.out.println(x));

        // Switch ints from intNumbersFlux to the right user from userFlux
        ReactiveSources.intNumbersFlux()
                .flatMap(x -> ReactiveSources.userFlux().filter(user -> user.getId() == x))
                .subscribe(x -> System.out.println(x));

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
