package store.studycafe.dto.request;

import lombok.Setter;

@Setter
public class UserCreateRequest {
    private String name;
    private String tel;

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}
