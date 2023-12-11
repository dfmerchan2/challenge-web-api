package api.co.com.petstore.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActorNotepad {
    USER_REQUEST("user request");

    private final String key;

}