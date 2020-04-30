package net.skhu.lms.repository;

import java.util.Optional;

import net.skhu.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserId(String userId);
}
