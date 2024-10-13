package store.studycafe.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

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

    public void updateUserTel(JdbcTemplate jdbcTemplate, String tel, long id){
        String updateSql = "UPDATE user SET tel = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, tel, id);
    }
}
