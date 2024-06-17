package jagarcia.mobile_app_ws.repository;

import jagarcia.mobile_app_ws.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
