package com.example.demo.util;
import com.github.javafaker.Faker;
import java.util.Random;
public class Util {
    private static Faker faker = new Faker();

    public static String getFakeFirstName(){
        return faker.name().firstName();
    }

    public static String getFakeFullName(){
        return faker.name().fullName();
    }

    public static String getFakeAddress(){
        return faker.address().fullAddress();
    }

    public static int getFakeNum(){
        return faker.number().numberBetween(1,10);
    }

    public static int getFakeAge() {
        Random r = new Random();
        int low = 18;
        int high = 88;
        int age = r.nextInt(high - low) + low;
        return age;
    }
}
