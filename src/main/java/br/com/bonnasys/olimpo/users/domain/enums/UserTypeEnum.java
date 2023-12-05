package br.com.bonnasys.olimpo.users.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    CLIENT("CLIENT"), EMPLOYEE("EMPLOYEE");

    private final String type;
}
