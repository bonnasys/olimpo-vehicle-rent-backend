package br.com.bonnasys.olimpo.common.api.handler;

import br.com.bonnasys.olimpo.users.domain.exception.UserEmailAlreadyInUseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = UserEmailAlreadyInUseException.class)
    public ResponseEntity<ApiError> handleUserEmailAlreadyInUseException(final UserEmailAlreadyInUseException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentialsException(final BadCredentialsException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(final AccessDeniedException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    public record ApiError(String message, Integer status, OffsetDateTime timestamp, List<String> errors) {
        static ApiError from(final UserEmailAlreadyInUseException ex) {
            return new ApiError(ex.getMessage(), 400, OffsetDateTime.now(), List.of());
        }

        static ApiError from(final BadCredentialsException ex) {
            return new ApiError("Invalid username or password!", 400, OffsetDateTime.now(), List.of(ex.getMessage()));
        }

        static ApiError from(final AccessDeniedException ex) {
            return new ApiError("Access denied", 400, OffsetDateTime.now(), List.of(ex.getMessage()));
        }
    }
}
