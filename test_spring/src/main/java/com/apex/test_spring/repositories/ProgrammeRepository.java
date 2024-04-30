package com.apex.test_spring.repositories;

import com.apex.test_spring.entities.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository  extends JpaRepository<Programme,Long> {

}
