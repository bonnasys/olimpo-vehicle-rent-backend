package br.com.bonnasys.olimpo.users.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("user was not found.", null, true, false);
    }

}
