package za.co.idol.assessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.idol.assessment.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

    User findById(long id);

}
