package store.studycafe.controller.user;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;
import store.studycafe.dto.request.UserCreateRequest;
import store.studycafe.dto.request.UserUpdateRequest;
import store.studycafe.dto.response.UserResponse;
import store.studycafe.service.UserService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class Usercontroller {

    private final JdbcTemplate jdbcTemplate;
    //UserService 클래스의 updateUser를 호출하기 위해 필드 추가
    private final UserService userService;

    public Usercontroller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = new UserService(jdbcTemplate);
    }

    //사용자 저장
    @PostMapping(path = "/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    //사용자 조회
    @GetMapping(path = "/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(jdbcTemplate, request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String tel){
        userService.deleteUser(tel);
    }
}
