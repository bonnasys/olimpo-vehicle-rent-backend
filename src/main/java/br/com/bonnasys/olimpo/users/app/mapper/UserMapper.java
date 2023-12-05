package br.com.bonnasys.olimpo.users.app.mapper;

import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserDetailedResponse;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserSummaryResponse;
import br.com.bonnasys.olimpo.users.domain.model.Client;
import br.com.bonnasys.olimpo.users.domain.model.Employee;
import br.com.bonnasys.olimpo.users.domain.model.User;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toUser(CreateUserRequest request);

    UserSummaryResponse toUserSummaryResponse(User user);


    UserDetailedResponse toUserDetailedResponse(User user);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "registration", ignore = true)
    UserDetailedResponse toUserDetailedResponse(Client user);

    @Mapping(target = "city", ignore = true)
    UserDetailedResponse toUserDetailedResponse(Employee user);

}
