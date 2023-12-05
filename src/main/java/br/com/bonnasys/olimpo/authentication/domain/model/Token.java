package br.com.bonnasys.olimpo.authentication.domain.model;

public record Token(String jwt, Integer expiresIn) {
}
