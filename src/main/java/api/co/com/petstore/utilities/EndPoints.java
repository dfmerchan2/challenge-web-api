package api.co.com.petstore.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoints {
    END_POINTS_BASE("https://petstore.swagger.io/v2/"),
    CREATE_USER("user"),
    USER("user/{username}");

    private final String value;
}
