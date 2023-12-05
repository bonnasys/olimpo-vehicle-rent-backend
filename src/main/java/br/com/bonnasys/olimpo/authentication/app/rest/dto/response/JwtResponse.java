package br.com.bonnasys.olimpo.authentication.app.rest.dto.response;

public record JwtResponse(String accessToken, int expiresIn) {
}
