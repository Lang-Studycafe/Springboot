package store.studycafe.domain;

public class User {

    private Long id;

    private String name;

    private String tel;


    // name 과 tel에 null이 들어오지 않고,비어있을 수도 없게 생성자에서 값 검증
    public User(String name, String tel){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        if (tel == null || tel.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 tel(%s)이 들어왔습니다", tel));
        }
        this.name = name;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    //    @OneToMany(mappedBy = "user")
//    private List<Reserve> orders = new ArrayList<>();

}