package br.com.bonnasys.olimpo.authentication.app.rest;

import br.com.bonnasys.olimpo.authentication.app.rest.dto.request.AuthRequest;
import br.com.bonnasys.olimpo.authentication.app.rest.dto.response.JwtResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "authentication")
@RequestMapping("authentication")
public interface AuthenticationApi {

    @PostMapping
    ResponseEntity<JwtResponse> authenticate(@RequestBody @Valid AuthRequest request);
}
