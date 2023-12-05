package br.com.bonnasys.olimpo.common.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService getUserDetails();

}
