package br.com.bonnasys.olimpo.cities.domain.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException() {
        super("city was not found", null, true, false);
    }
}
