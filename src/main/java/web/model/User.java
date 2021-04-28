package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Wrong name size")
    @Column
    private String name;
    @NotEmpty(message = "lastname should not be empty")
    @Size(min = 2, max = 20, message = "Wrong lastname size")
    @Column
    private String lastname;
    @Column
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    public User() {

    }

    public User(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'';
    }
}
