package io.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(num -> System.out.println(num));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(x -> x < 5).forEach(num -> System.out.println(num));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(x -> x > 5)
                .skip(1) //skip fist n elements
                .limit(2) //After skip, how many elements do you want
                .forEach(num -> System.out.println());

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer i = StreamSources.intNumbersStream().filter(x -> x > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(i);
        // Print first names of all users in userStream
        StreamSources.userStream().forEach(x -> System.out.println(x.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().filter(x -> StreamSources.intNumbersStream().toList().contains(x.getId()))
                .forEach(x -> System.out.println(x.getFirstName()));

    }

}
