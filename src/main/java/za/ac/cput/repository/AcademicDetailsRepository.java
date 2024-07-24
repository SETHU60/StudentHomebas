package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.AcademicDetails;
@Repository
public interface AcademicDetailsRepository extends JpaRepository<AcademicDetails,String> {
}
