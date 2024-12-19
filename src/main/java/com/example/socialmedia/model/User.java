package com.example.socialmedia.model;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

=======
import lombok.Data;
import lombok.Getter;
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
=======
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
@Document(collection = "users")
public class User {

    @Id
    private String id;
    @Getter
<<<<<<< HEAD
    @Setter
    private String Username;
=======
    private String username;
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
    private String password; // Stored hashed password
    private String email;

    // Constructor for registration
<<<<<<< HEAD
}
=======
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
