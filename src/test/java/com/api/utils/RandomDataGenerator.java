package com.api.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

	
public  static	Faker faker = new Faker ();
	

public static int randomId() {
	return faker.number().randomDigit();
}

public static String randomFirstName() {
	return faker.name().firstName();
}
public static String randomLastName() {
	return faker.name().lastName();
}
}
