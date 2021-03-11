public class User {
    private int id;
    private String name;
    private String password;
    private String email;

    public static int numberOfUSERS=-1;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;

    }
    public String userToString(){
        return this.id+". "+this.name+ " email: "+this.email;
    }
}
