package com.cydeo.tests.day10_java_faker_driver_util;

import org.testng.annotations.Test;

public class TestingSingleton {

    @Test
    public void SingletonTest() {

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);

    }
        @Test
        public void SingletonTest2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);


    }

}
