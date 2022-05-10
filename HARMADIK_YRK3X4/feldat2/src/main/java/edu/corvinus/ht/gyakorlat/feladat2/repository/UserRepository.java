package edu.corvinus.ht.gyakorlat.feladat2.repository;

import edu.corvinus.ht.gyakorlat.feladat2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
