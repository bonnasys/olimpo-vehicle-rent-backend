package br.com.bonnasys.olimpo.users.domain.exception;

public class UserEmailAlreadyInUseException extends RuntimeException {

    public UserEmailAlreadyInUseException(String email) {
        super("email: '%s' already in use.".formatted(email), null, true, false);
    }
}
