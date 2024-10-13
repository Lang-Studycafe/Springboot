package store.studycafe.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import store.studycafe.dto.response.UserResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// DB에 SQL을 날리는 역할
public class UserRepository {
    //기존의 JdbcTemplate이 파라미터를 통해 계속해서 전달하는 점을 개선하기 위해 JdbcTemplate을 변수와 생성자 생성
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public boolean isUserNoExist(JdbcTemplate jdbcTemplate, long id){
        String readSql = "SELECT * FROM user WHERE id =?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public boolean isUserNoExist(String tel) {
        String readSql = "SELECT * FROM user WHERE tel = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, tel).isEmpty();
    }

    public void saveUser(String name, String tel){
        String sql = "INSERT INTO user(name, tel) VALUES(?, ?)";
        jdbcTemplate.update(sql, name, tel);
    }

    public List<UserResponse> getUserResponses() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->  {

            long id = rs.getLong("id");
            String name = rs.getString("name");
            String tel = rs.getString("tel");
            return new UserResponse(id, name, tel);
        });
    }

    public void updateUserTel(JdbcTemplate jdbcTemplate, String tel, long id){
        String updateSql = "UPDATE user SET tel = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, tel, id);
    }

    public void deleteUserByTel(String tel){
        String sql = "DELETE FROM user WHERE tel = ?";
        jdbcTemplate.update(sql, tel);
    }
}
