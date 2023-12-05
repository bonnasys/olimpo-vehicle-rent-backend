package br.com.bonnasys.olimpo.common.api.handler;

import br.com.bonnasys.olimpo.users.domain.exception.UserEmailAlreadyInUseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = UserEmailAlreadyInUseException.class)
    public ResponseEntity<ApiError> handleUserEmailAlreadyInUseException(final UserEmailAlreadyInUseException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    public record ApiError(String message, Integer status, OffsetDateTime timestamp, List<Error> errors) {
        static ApiError from(final UserEmailAlreadyInUseException ex) {
            return new ApiError(ex.getMessage(), 400, OffsetDateTime.now(), List.of());
        }
    }
}
