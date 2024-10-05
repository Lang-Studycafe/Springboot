package store.studycafe.dto.response;

import store.studycafe.domain.User;

public class UserResponse {

    private long id;
    private String name;
    private String tel;

    public UserResponse(long id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
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
