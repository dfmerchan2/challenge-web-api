package api.co.com.petstore.models.builder;

import api.co.com.petstore.models.User;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Locale;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

    private static final Faker faker = new Faker(new Locale("es-MX"));

    public static User userRequest() {
        return User.builder()
                .id(Integer.parseInt(faker.number().digits(5)))
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.number().digits(10))
                .userStatus(0)
                .build();
    }

    public static User updateUser(User user){
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(faker.name().firstName())
                .lastName(user.getLastName())
                .email(faker.internet().emailAddress())
                .password(user.getPassword())
                .phone(user.getPhone())
                .userStatus(0)
                .build();
    }
}
