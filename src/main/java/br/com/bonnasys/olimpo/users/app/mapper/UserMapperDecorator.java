package br.com.bonnasys.olimpo.users.app.mapper;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserClientRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserEmployeeRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserDetailedResponse;
import br.com.bonnasys.olimpo.users.domain.model.Client;
import br.com.bonnasys.olimpo.users.domain.model.Employee;
import br.com.bonnasys.olimpo.users.domain.model.Role;
import br.com.bonnasys.olimpo.users.domain.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    ObjectMapper mapper;

    @Override
    public User toUser(CreateUserRequest request) {
        User user = mapper.convertValue(request, User.class);

        if (user instanceof Client client && request instanceof CreateUserClientRequest clientRequest) {
            client.setCity(new City(clientRequest.getCityId()));
        }
        if (user instanceof Employee employee && request instanceof CreateUserEmployeeRequest clientRequest) {
            employee.setRole(new Role(clientRequest.getRole()));
        }
        return user;
    }

    @Override
    public UserDetailedResponse toUserDetailedResponse(User user) {
        if (user instanceof Client client) {
            return this.toUserDetailedResponse(client);
        }
        if (user instanceof Employee employee) {
            return this.toUserDetailedResponse(employee);
        }
        throw new IllegalStateException("Unexpected instance of userDetail");
    }
}
