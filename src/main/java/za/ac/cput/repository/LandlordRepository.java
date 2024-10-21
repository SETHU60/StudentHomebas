package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Landlord;
import za.ac.cput.domain.Student;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    @Query("SELECT l FROM Landlord l WHERE l.contact.email = :email AND l.password = :password")
    Landlord findByContactEmailAndPassword(@Param("email") String email, @Param("password") String password);
}


