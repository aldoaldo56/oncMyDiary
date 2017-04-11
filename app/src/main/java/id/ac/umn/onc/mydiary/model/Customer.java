package id.ac.umn.onc.mydiary.model;

/**
 * Created by ASUS-PC on 11/04/2017.
 */

public class Customer {
    private Integer Id;
    private String Email;
    private String Password;
    private String Name;

    public Customer() {
    }

    public Customer(Integer id, String email, String password, String name) {
        Id = id;
        Email = email;
        Password = password;
        Name = name;
    }

    public Customer(String email, String password, String name) {
        Email = email;
        Password = password;
        Name = name;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }
}
