package za.co.idol.assessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.idol.assessment.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

    User findById(long id);

}
