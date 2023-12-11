package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBody<T> implements Question<T> {

    private final Class<T> tClass;
    private final String path;

    public ResponseBody(Class<T> tClass, String path) {
        this.tClass = tClass;
        this.path = path;
    }

    @Override
    public T answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getObject(path, tClass);
    }
}