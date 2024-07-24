package za.ac.cput.repository;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.PropertyListingApplication;

@Repository
public interface PropertyListingApplicationRepository extends JpaRepository<PropertyListingApplication, Long> {

}
