package com.epam.mentoringportal.repository;

import com.epam.mentoringportal.domain.MenteeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tim Ryzhov
 */
@Repository
public interface MenteeRepository extends JpaRepository<MenteeEntity, Integer> {

    MenteeEntity findByEmail(String email);
}
