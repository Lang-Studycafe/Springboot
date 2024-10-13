package store.studycafe.service;

import org.springframework.jdbc.core.JdbcTemplate;
import store.studycafe.dto.request.UserUpdateRequest;
import store.studycafe.repository.user.UserRepository;

public class UserService {

    private UserRepository userRepository;

    //생성자가 생기고, UserRepository 타입의 필드를 만들어 줄 때 JdbcTemplate를 받아 UserRepository로 전달함
    public UserService(JdbcTemplate jdbcTemplate){
        this.userRepository = new UserRepository(jdbcTemplate);
    }

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request){
        if (userRepository.isUserNoExist(jdbcTemplate, request.getId())){
            throw new IllegalArgumentException();
        }

        userRepository.updateUserTel(jdbcTemplate, request.getTel(), request.getId());
    }
}
