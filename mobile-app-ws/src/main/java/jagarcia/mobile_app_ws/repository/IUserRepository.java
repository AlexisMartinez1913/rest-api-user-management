package jagarcia.mobile_app_ws.repository;

import jagarcia.mobile_app_ws.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IUserRepository extends JpaRepository<User, Long> {
}
