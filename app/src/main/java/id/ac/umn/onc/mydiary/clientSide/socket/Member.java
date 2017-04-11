package id.ac.umn.onc.mydiary.clientSide.socket;

/**
 * Created by aldo_ on 11/04/2017.
 */

public class Member {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String firstName;
    private String lastName;
    private Integer privilege;

    public Member() {
    }

    public Member(String username, String password, String salt, String firstName, String lastName, Integer privilege) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.privilege = privilege;
    }

    public Member(Integer id, String username, String password, String salt, String firstName, String lastName, Integer privilege) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.privilege = privilege;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPrivilege() {
        return privilege;
    }
}
