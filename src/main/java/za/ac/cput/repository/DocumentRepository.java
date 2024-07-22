package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
