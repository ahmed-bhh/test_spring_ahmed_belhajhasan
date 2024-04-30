package com.apex.test_spring.repositories;

import com.apex.test_spring.entities.Chaine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaineRepository  extends JpaRepository<Chaine,Long> {
}
