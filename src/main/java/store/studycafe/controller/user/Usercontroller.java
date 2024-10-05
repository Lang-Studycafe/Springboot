package store.studycafe.controller.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import store.studycafe.domain.User;
import store.studycafe.dto.request.UserCreateRequest;
import store.studycafe.dto.response.UserResponse;


import java.util.ArrayList;
import java.util.List;

@RestController
public class Usercontroller {

    private final List<User> users = new ArrayList<>();

    //사용자 저장
    @PostMapping(path = "/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        User newUser = new User(request.getName(), request.getTel());
        users.add(newUser);
    }

    //사용자 조회
    @GetMapping(path = "/user")
    public List<UserResponse> getUsers() {
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0 ; i < users.size() ; i++){
            responses.add(new UserResponse(i + 1, users.get(i)));
        }
       return responses;
    }
}
