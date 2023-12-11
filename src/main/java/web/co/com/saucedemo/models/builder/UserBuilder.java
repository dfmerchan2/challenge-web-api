package web.co.com.saucedemo.models.builder;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import web.co.com.saucedemo.models.User;

import java.util.Locale;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

    private static final Faker faker = new Faker(new Locale("es-MX"));

    public static User datUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .postalCode(faker.number().digits(10))
                .build();
    }

}
