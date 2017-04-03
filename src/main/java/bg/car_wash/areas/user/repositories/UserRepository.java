package bg.car_wash.areas.user.repositories;

import bg.car_wash.areas.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	@Query("SELECT u FROM User AS u WHERE u.email = :email AND u.password = :password")
//	User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	List<User> findAll();

	User findOneByEmail(String email);
}