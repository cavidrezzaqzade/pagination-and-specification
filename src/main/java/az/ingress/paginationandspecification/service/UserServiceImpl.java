package az.ingress.paginationandspecification.service;

import az.ingress.paginationandspecification.client.CatFactClient;
import az.ingress.paginationandspecification.dao.entity.User;
import az.ingress.paginationandspecification.dao.repository.UserRepository;
import az.ingress.paginationandspecification.mapper.PageableMapper;
import az.ingress.paginationandspecification.mapper.UserMapper;
import az.ingress.paginationandspecification.model.UserDetails;
import az.ingress.paginationandspecification.model.UserDto;
import az.ingress.paginationandspecification.model.criteria.PageCriteria;
import az.ingress.paginationandspecification.model.criteria.UserCriteria;
import az.ingress.paginationandspecification.model.response.PageableUserResponse;
import az.ingress.paginationandspecification.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PageableMapper pageableMapper;
    private final CatFactClient client;

    private static final Integer PAGE_DEFAULT = 1;
    private static final Integer COUNT_DEFAULT = 10;

    @Override
    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        repository.delete(user);
    }

    @Override
    public UserDto update(UserDto dto, Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
        User userNew = mapper.updateUser(user, dto);
        return mapper.entityToDto(repository.save(userNew));
    }

    @Override
    public UserDto update(UserDetails userDetails) {
        User user = repository.findById(userDetails.getId()).orElseThrow(() -> new RuntimeException("user was not found"));

        user.setAge(userDetails.getAge());
        user.setName(userDetails.getName());

        return mapper.entityToDto(repository.save(user));
    }

    @Override
    public PageableUserResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria) {

        var pageNumber = pageCriteria.getPage() == null ? PAGE_DEFAULT : pageCriteria.getPage();
        var count = pageCriteria.getCount() == null ? COUNT_DEFAULT : pageCriteria.getCount();

        Page<User> usersPage = repository.findAll(new UserSpecification(userCriteria), PageRequest.of(pageNumber, count));
        return pageableMapper.mapToPageableResponse(usersPage);
    }
}
