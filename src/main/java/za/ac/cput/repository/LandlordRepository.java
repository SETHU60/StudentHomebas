package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord, Long> {
}
