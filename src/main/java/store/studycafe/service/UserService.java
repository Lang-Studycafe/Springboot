package store.studycafe.service;

import org.springframework.jdbc.core.JdbcTemplate;
import store.studycafe.dto.request.UserUpdateRequest;
import store.studycafe.repository.user.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request){
        if (userRepository.isUserNoExist(jdbcTemplate, request.getId())){
            throw new IllegalArgumentException();
        }

        userRepository.updateUserTel(jdbcTemplate, request.getTel(), request.getId());
    }
}
