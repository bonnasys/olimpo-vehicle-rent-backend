package br.com.bonnasys.olimpo.common.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String retrieveEmail(String jwt);

    boolean tokenIsValid(String jwt, UserDetails userDetails);

    String generateToken(UserDetails userDetails);
}
