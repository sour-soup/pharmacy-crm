package org.soup.dataservice.repository;


import org.soup.dataservice.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
}
