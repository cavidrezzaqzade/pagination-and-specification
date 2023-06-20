package az.ingress.paginationandspecification.service;

import az.ingress.paginationandspecification.model.UserDetails;
import az.ingress.paginationandspecification.model.UserDto;
import az.ingress.paginationandspecification.model.criteria.PageCriteria;
import az.ingress.paginationandspecification.model.criteria.UserCriteria;
import az.ingress.paginationandspecification.model.response.PageableUserResponse;

import java.util.List;

/**
 * @author caci
 */

public interface UserService {

    List<UserDto> getAll();

    UserDto add(UserDto userDto);

    void delete(Long id);

    UserDto update(UserDto dto, Long id);

    UserDto update(UserDetails userDetails);

    PageableUserResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria);
}
