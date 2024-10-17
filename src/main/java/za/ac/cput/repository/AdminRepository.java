package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("SELECT A FROM Admin A WHERE A.contact.email = :email AND A.password = :password")
    Admin findByContactEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
