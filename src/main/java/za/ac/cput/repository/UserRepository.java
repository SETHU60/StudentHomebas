package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   // Optional<User> findByEmail(String email);
}
