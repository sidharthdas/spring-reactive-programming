package io.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        /*ReactiveSources.intNumbersFlux().subscribe(
                x -> System.out.println(x),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );*/

        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);
    }

    public void hookOnNext(T t) {
        System.out.println("Value is : " + t.toString());
        request(1); //chaining this is backpressure. like how much data can we process.
        //This is not trying to get the object, rather is is sending a message that it's ok to push new object and we are
        //ready for processing.
    }
}