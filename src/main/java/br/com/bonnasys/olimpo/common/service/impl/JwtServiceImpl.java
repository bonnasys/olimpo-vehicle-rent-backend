package br.com.bonnasys.olimpo.common.service.impl;

import br.com.bonnasys.olimpo.common.configuration.JwtUtil;
import br.com.bonnasys.olimpo.common.service.JwtService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    private final JwtUtil jwtUtil;

    public JwtServiceImpl() {
        this.jwtUtil = new JwtUtil();
    }

    @Override
    public String retrieveEmail(String token) {
        return jwtUtil.extractUserName(token);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public boolean tokenIsValid(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails);
    }

}
