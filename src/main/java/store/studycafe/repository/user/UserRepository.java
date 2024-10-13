package store.studycafe.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

// DB에 SQL을 날리는 역할
public class UserRepository {

    public boolean isUserNoExist(JdbcTemplate jdbcTemplate, long id){
        String readSql = "SELECT * FROM user WHERE id =?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserTel(JdbcTemplate jdbcTemplate, String tel, long id){
        String updateSql = "UPDATE user SET tel = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, tel, id);
    }
}
