package za.ac.cput.repository;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 23 July 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.StudentApplication;

@Repository
public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Long> {

}
