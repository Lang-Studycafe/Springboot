package store.studycafe.service;

import org.springframework.jdbc.core.JdbcTemplate;
import store.studycafe.dto.request.UserUpdateRequest;

public class UserService {

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request){
        String readSql = "SELECT * FROM user WHERE id =?";
        boolean isUserNoExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNoExist){
            throw new IllegalArgumentException();
        }

        String updateSql = "UPDATE user SET tel = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, request.getTel(), request.getId());
    }
}
