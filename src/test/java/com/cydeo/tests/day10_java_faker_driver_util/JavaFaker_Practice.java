package com.cydeo.tests.day10_java_faker_driver_util;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_Practice {

    @Test
    public void java_faker_test(){

        Faker faker = new Faker();

        System.out.println("random human name\n-----------------");
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("------------------\nrandom names\n----------------");
        System.out.println("faker.app().name() = " + faker.app().name());
        System.out.println("faker.dragonBall().character() = " + faker.dragonBall().character());
        System.out.println("faker.funnyName().name() = " + faker.funnyName().name());
        System.out.println("faker.color().name() = " + faker.color().name());

        System.out.println("-------------------\nrandom numbers and letters\n-------------------");
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("607-###-####"));
        System.out.println("faker.numerify(\"#####\") = " + faker.numerify("#####"));
        System.out.println("faker.letterify(\"???????\") = " + faker.letterify("???????"));
        System.out.println("faker.bothify(\"##???#??\") = " + faker.bothify("##???#??")); // letterify and numberify random
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.finance().creditCard().replaceAll(\"-\", \"\") = " + faker.finance().creditCard().replaceAll("-", ""));

        System.out.println("---------------------\nother\n--------------------");

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact().replaceAll(\"Chuck Norris\", \"Saim\") = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Saim"));

        System.out.println("faker.food().dish() = " + faker.food().dish());

    }

}
