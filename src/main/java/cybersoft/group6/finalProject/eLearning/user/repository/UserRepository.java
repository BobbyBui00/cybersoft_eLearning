package cybersoft.group6.finalProject.eLearning.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import cybersoft.group6.finalProject.eLearning.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByInstructors(String username);
	
	Optional<User> findById(Long userId);

	User findByUsername(String user);
	
}
