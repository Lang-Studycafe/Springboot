package store.studycafe.dto.response;

import store.studycafe.domain.User;

public class UserResponse {

    private long id;
    private String name;
    private String tel;

    public UserResponse(long id, User user){
        this.id = id;
        this.name = user.getName();
        this.tel = user.getTel();
    }

    public long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getTel(){
        return tel;
    }
}
