package ru.netology.delivery.data.;

import com.github.javafaker.Faker;
import lombok.Value;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateData(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {                   // Генеротор выбора города
        var cities = new String[]{"Омс", "Москва", "Санкт-Петербург", "Минск", "Орел", "Владимир"};
        return  cities [new Random().nextInt(cities.length)];

    }
    public static String generateName (String locale) {             //Генератор имя и фамилии пользователя
        var faker = new Faker(new Locale("ru"));
        return  faker.name().lastName() +" " +faker.name().lastName();
    }

    public  static String generatePhoneNumber (String locale) {     //Генератор номера телефона
        var faker = new Faker(new Locale("ru"));
        return  faker.phoneNumber().phoneNumber();
    }

    public static  class Registration {
        private Registration(){
        }

        public static User generateUser(String locale){
            return new User(generateCity(), generateName(locale), generatePhoneNumber(locale));
        }
    }

    @Value
    public static  class  User{                                      //Какие данные есть у пользователя
        String city;
        String name;
        String PhoneNumber;
    }
}