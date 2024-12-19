package com.example.socialmedia.repository;

import com.example.socialmedia.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.example.socialmedia")
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
<<<<<<< HEAD

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);
=======
    boolean existsByUsername(String username);
>>>>>>> 7b9efdd25cb65b5662c569204d6822a683a38e78
}
